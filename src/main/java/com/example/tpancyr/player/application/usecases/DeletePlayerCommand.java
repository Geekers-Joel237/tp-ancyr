package com.example.tpancyr.player.application.usecases;

import an.awesome.pipelinr.Command;

public record DeletePlayerCommand(String id) implements Command<Void> {
}
