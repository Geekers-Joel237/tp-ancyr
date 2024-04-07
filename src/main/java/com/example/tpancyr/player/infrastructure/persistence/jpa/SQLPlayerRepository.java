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
        var sqlPlayerQuery = dataAccessor.findById(id);
        if (sqlPlayerQuery.isEmpty()) {
            return null;
        }
        var sqlPlayer = sqlPlayerQuery.get();
        return new Player(sqlPlayer.getId(), sqlPlayer.getName());
    }

    @Override
    public void save(Player player) {
        var sqlPlayer = new SQLPlayer(player.getId(), player.getName());
        dataAccessor.save(sqlPlayer);
    }
}
