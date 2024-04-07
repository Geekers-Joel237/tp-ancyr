package com.example.tpancyr.player.infrastructure.spring;

import com.example.tpancyr.player.application.usecases.CreatePlayerUseCase;
import com.example.tpancyr.player.domain.viewmodel.IdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final CreatePlayerUseCase createPlayerUseCase;

    public PlayerController(CreatePlayerUseCase useCase) {
        this.createPlayerUseCase = useCase;
    }

    @PostMapping
    public ResponseEntity<IdResponse> createPlayer(@RequestBody CreatePlayerDto dto) {
        var result = this.createPlayerUseCase.handle(dto.getName());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
