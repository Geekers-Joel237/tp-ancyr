package com.example.tpancyr.player.infrastructure.persistence.jpa;

import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.model.Player;


public class SQLPlayerRepository implements PlayerRepository {
    private final SQLPlayerDataAccessor dataAccessor;

    public SQLPlayerRepository(SQLPlayerDataAccessor sqlPlayerDataAccessor) {
        this.dataAccessor = sqlPlayerDataAccessor;
    }

    @Override
    public Player findById(String id) {
        var player = dataAccessor.findById(id);
        return player.orElse(null);
    }

    @Override
    public void save(Player player) {
        dataAccessor.save(player);
    }
}
