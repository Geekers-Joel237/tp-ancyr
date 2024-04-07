package com.example.tpancyr.player.infrastructure.spring;

import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.infrastructure.persistence.ram.InMemoryPlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfiguration {
    @Bean
    public PlayerRepository playerRepository() {
        return new InMemoryPlayerRepository();
    }
}
