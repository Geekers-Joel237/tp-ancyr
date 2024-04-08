package com.example.tpancyr.player.infrastructure.spring;

public class RenamePlayerDto {
    private String name;

    public RenamePlayerDto() {
    }

    public RenamePlayerDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
