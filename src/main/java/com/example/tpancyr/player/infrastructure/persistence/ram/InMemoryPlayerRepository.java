package com.example.tpancyr.player.infrastructure.persistence.ram;

import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.model.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryPlayerRepository implements PlayerRepository {
    private final Map<String, Player> players = new HashMap<>();

    @Override
    public Optional<Player> findById(String id) {
        return Optional.ofNullable(players.get(id));
    }

    @Override
    public void save(Player player) {
        players.put(player.getId(), player);
    }
}
