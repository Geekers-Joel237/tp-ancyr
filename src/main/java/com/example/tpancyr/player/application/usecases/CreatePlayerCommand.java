package com.example.tpancyr.player.application.usecases;

import an.awesome.pipelinr.Command;
import com.example.tpancyr.player.domain.viewmodel.IdResponse;

public class CreatePlayerCommand implements Command<IdResponse> {
    private String name;

    public CreatePlayerCommand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
