package com.example.tpancyr.player.infrastructure.spring;

import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.infrastructure.persistence.jpa.SQLPlayerDataAccessor;
import com.example.tpancyr.player.infrastructure.persistence.jpa.SQLPlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfiguration {
    @Bean
    public PlayerRepository playerRepository(
            SQLPlayerDataAccessor dataAccessor
    ) {
        return new SQLPlayerRepository(dataAccessor);
    }
}
