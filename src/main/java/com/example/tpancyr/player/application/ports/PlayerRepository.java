package com.example.tpancyr.player.application.ports;

import com.example.tpancyr.player.domain.model.Player;

import java.util.Optional;

public interface PlayerRepository {
    Optional<Player> findById(String id);

    void save(Player player);
}
