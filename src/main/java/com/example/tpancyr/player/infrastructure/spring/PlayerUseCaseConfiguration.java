package com.example.tpancyr.player.infrastructure.spring;

import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.application.usecases.CreatePlayerCommandHandler;
import com.example.tpancyr.player.application.usecases.DeletePlayerCommandHandler;
import com.example.tpancyr.player.application.usecases.GetPlayerCommandHandler;
import com.example.tpancyr.player.application.usecases.RenamePlayerCommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerUseCaseConfiguration {
    @Bean
    public CreatePlayerCommandHandler createPlayerUseCase(PlayerRepository repository) {
        return new CreatePlayerCommandHandler(repository);
    }

    @Bean
    public RenamePlayerCommandHandler renamePlayerUseCase(PlayerRepository repository) {
        return new RenamePlayerCommandHandler(repository);
    }

    @Bean
    public DeletePlayerCommandHandler deletePlayerUseCase(PlayerRepository repository){
        return new DeletePlayerCommandHandler(repository);
    }

    @Bean
    public GetPlayerCommandHandler getPlayerUseCase(PlayerRepository repository){
        return new GetPlayerCommandHandler(repository);
    }
}
