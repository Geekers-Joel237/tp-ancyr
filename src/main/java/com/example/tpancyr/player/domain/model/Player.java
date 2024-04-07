package com.example.tpancyr.player.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "players")
public class Player {
    @Id
    private String id;
    @Column()
    private String name;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
