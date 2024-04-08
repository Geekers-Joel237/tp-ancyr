package com.example.tpancyr.player;

import com.example.tpancyr.core.domain.exceptions.NotFoundException;
import com.example.tpancyr.player.application.usecases.RenamePlayerCommand;
import com.example.tpancyr.player.application.usecases.RenamePlayerCommandHandler;
import com.example.tpancyr.player.domain.model.Player;
import com.example.tpancyr.player.infrastructure.persistence.ram.InMemoryPlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RenamePlayerTests {
    @Test
    public void ShouldCreateUser() {
        var playerRepository = new InMemoryPlayerRepository();
        var player = new Player("123", "old name");
        playerRepository.save(player);
        var command = new RenamePlayerCommand(player.getId(), "new name");

        var commandHandler = new RenamePlayerCommandHandler(playerRepository);
        commandHandler.handle(command);
        Player actualPlayer = playerRepository.findById(player.getId()).get();

        Assertions.assertEquals(command.getName(), actualPlayer.getName());
    }

    @Test
    public void ShouldThrowNotFoundWhenPlayerDoesNotExist() {
        var playerRepository = new InMemoryPlayerRepository();

        var command = new RenamePlayerCommand("garbage", "new name");

        var commandHandler = new RenamePlayerCommandHandler(playerRepository);
        Assertions.assertThrows(NotFoundException.class, () -> commandHandler.handle(command)
        );

    }
}
