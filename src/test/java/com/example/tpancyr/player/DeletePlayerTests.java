package com.example.tpancyr.player;

import com.example.tpancyr.core.domain.exceptions.NotFoundException;
import com.example.tpancyr.player.application.usecases.DeletePlayerCommand;
import com.example.tpancyr.player.application.usecases.DeletePlayerCommandHandler;
import com.example.tpancyr.player.domain.model.Player;
import com.example.tpancyr.player.infrastructure.persistence.ram.InMemoryPlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeletePlayerTests {
    @Test
    public void ShouldDeletePlayer() {
        var playerRepository = new InMemoryPlayerRepository();
        var player = new Player("123", "old name");
        playerRepository.save(player);
        var command = new DeletePlayerCommand(player.getId());

        var commandHandler = new DeletePlayerCommandHandler(playerRepository);
        commandHandler.handle(command);
        var playerQuery = playerRepository.findById(player.getId());

        Assertions.assertTrue(playerQuery.isEmpty());
    }

    @Test
    public void ShouldThrowNotFoundWhenPlayerDoesNotExist() {
        var playerRepository = new InMemoryPlayerRepository();

        var command = new DeletePlayerCommand("garbage");

        var commandHandler = new DeletePlayerCommandHandler(playerRepository);

        Assertions.assertThrows(NotFoundException.class, () -> commandHandler.handle(command)
        );

    }
}
