package com.example.tpancyr.player.infrastructure.spring;

public class CreatePlayerDto {
    private String name;

    public CreatePlayerDto() {
    }

    public CreatePlayerDto(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
