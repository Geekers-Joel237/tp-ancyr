package com.example.tpancyr.player.infrastructure.spring;

import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.application.usecases.CreatePlayerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerUseCaseConfiguration {
    @Bean
    public CreatePlayerUseCase createPlayerUseCase(PlayerRepository repository) {
        return new CreatePlayerUseCase(repository);
    }
}
