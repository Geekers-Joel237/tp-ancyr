package com.example.tpancyr.player.application.ports;

import com.example.tpancyr.player.domain.model.Player;

public interface PlayerRepository {
    Player findById(String id);

    void save(Player player);
}
