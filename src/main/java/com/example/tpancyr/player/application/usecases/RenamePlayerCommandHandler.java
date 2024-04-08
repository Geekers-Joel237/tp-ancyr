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
        var playerQuery = playerRepository.findById(command.getId());
        if (playerQuery.isEmpty()){
            throw new NotFoundException("Player not found");
        }
        var player =playerQuery.get();
        player.rename(command.getName());
        playerRepository.save(player);
        return null;
    }
}
