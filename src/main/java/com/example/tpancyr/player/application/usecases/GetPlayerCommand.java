package com.example.tpancyr.player.application.usecases;

import an.awesome.pipelinr.Command;
import com.example.tpancyr.player.domain.viewmodel.PlayerViewModel;

public record GetPlayerCommand(String id) implements Command<PlayerViewModel> {
}
