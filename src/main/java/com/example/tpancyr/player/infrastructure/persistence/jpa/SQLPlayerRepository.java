package com.example.tpancyr.player.infrastructure.persistence.jpa;

import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.model.Player;

import java.util.Optional;


public class SQLPlayerRepository implements PlayerRepository {
    private final SQLPlayerDataAccessor dataAccessor;

    public SQLPlayerRepository(SQLPlayerDataAccessor sqlPlayerDataAccessor) {
        this.dataAccessor = sqlPlayerDataAccessor;
    }

    @Override
    public Optional<Player> findById(String id) {
        return dataAccessor.findById(id);
    }

    @Override
    public void save(Player player) {
        dataAccessor.save(player);
    }

    @Override
    public void delete(Player player) {
        dataAccessor.delete(player);
    }
}
