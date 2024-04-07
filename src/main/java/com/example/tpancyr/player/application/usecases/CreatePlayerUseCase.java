package com.example.tpancyr.player.application.usecases;

import an.awesome.pipelinr.Command;
import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.model.Player;
import com.example.tpancyr.player.domain.viewmodel.IdResponse;

import java.util.UUID;

public class CreatePlayerUseCase implements Command.Handler<CreatePlayerCommand, IdResponse> {
    private final PlayerRepository repository;

    public CreatePlayerUseCase(PlayerRepository repository) {
        this.repository = repository;
    }


    public IdResponse handle(CreatePlayerCommand command) {
        var player = new Player(UUID.randomUUID().toString(), command.getName());
        repository.save(player);
        return new IdResponse(player.getId());
    }


}
