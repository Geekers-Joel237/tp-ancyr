package com.example.tpancyr.player;
import com.example.tpancyr.player.application.usecases.CreatePlayerUseCase;
import com.example.tpancyr.player.domain.model.Player;
import com.example.tpancyr.player.infrastructure.persistence.ram.InMemoryPlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreatePlayerTests {
    @Test
    public void ShouldCreateUser() {

        var repository = new InMemoryPlayerRepository();
        var userCase = new CreatePlayerUseCase(repository);

        var result = userCase.handle("name");

        var expectedPlayer = new Player(result.getId(), "name");
        Player actualPlayer = repository.findById(expectedPlayer.getId());

        Assertions.assertEquals(expectedPlayer.getName(), actualPlayer.getName());
    }


}
