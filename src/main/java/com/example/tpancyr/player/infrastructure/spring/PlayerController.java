package com.example.tpancyr.player.infrastructure.spring;

import an.awesome.pipelinr.Pipeline;
import com.example.tpancyr.player.application.usecases.CreatePlayerCommand;
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
    private final Pipeline pipeline;

    public PlayerController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping
    public ResponseEntity<IdResponse> createPlayer(@RequestBody CreatePlayerDto dto) {
        var result = this.pipeline.send(new CreatePlayerCommand(dto.getName()));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
