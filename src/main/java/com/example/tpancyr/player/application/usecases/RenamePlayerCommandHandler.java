package com.example.tpancyr.player.application.usecases;

import an.awesome.pipelinr.Command;
import com.example.tpancyr.core.domain.exceptions.NotFoundException;
import com.example.tpancyr.player.application.ports.PlayerRepository;

public class RenamePlayerCommandHandler implements Command.Handler<RenamePlayerCommand, Void> {

    private final PlayerRepository playerRepository;

    public RenamePlayerCommandHandler(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Void handle(RenamePlayerCommand command) {
        var player = playerRepository.findById(command.getId()).orElseThrow(
                () ->  new NotFoundException("Player not found")
        );

        player.rename(command.getName());
        playerRepository.save(player);
        return null;
    }
}
