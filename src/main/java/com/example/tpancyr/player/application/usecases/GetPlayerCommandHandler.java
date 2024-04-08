package com.example.tpancyr.player.application.usecases;

import an.awesome.pipelinr.Command;
import com.example.tpancyr.core.domain.exceptions.NotFoundException;
import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.viewmodel.PlayerViewModel;

public class GetPlayerCommandHandler implements Command.Handler<GetPlayerCommand, PlayerViewModel> {
    private final PlayerRepository playerRepository;

    public GetPlayerCommandHandler(PlayerRepository repository){
        this.playerRepository = repository;
    }


    @Override
    public PlayerViewModel handle(GetPlayerCommand getPlayerCommand) {
        var player = playerRepository.findById(getPlayerCommand.id()).orElseThrow(
                () -> new NotFoundException("Player not found !")
        );
        return new PlayerViewModel(player.getId(), player.getName());
    }
}
