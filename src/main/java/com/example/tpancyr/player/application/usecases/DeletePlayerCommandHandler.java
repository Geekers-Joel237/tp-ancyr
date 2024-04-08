package com.example.tpancyr.player.application.usecases;

import an.awesome.pipelinr.Command;
import com.example.tpancyr.core.domain.exceptions.NotFoundException;
import com.example.tpancyr.player.application.ports.PlayerRepository;

public class DeletePlayerCommandHandler implements Command.Handler<DeletePlayerCommand, Void> {
    private final PlayerRepository playerRepository;

    public DeletePlayerCommandHandler(PlayerRepository repository) {
        this.playerRepository = repository;
    }

    @Override
    public Void handle(DeletePlayerCommand deletePlayerCommand) {
        var player = playerRepository.findById(deletePlayerCommand.id()).orElseThrow(
                () -> new NotFoundException("Player Not Found")
        );
        playerRepository.delete(player);
        return null;
    }
}
