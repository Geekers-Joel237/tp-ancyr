package com.example.tpancyr.player.infrastructure.spring;

import an.awesome.pipelinr.Pipeline;
import com.example.tpancyr.player.application.usecases.CreatePlayerCommand;
import com.example.tpancyr.player.application.usecases.DeletePlayerCommand;
import com.example.tpancyr.player.application.usecases.GetPlayerCommand;
import com.example.tpancyr.player.application.usecases.RenamePlayerCommand;
import com.example.tpancyr.player.domain.viewmodel.IdResponse;
import com.example.tpancyr.player.domain.viewmodel.PlayerViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final Pipeline pipeline;

    public PlayerController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerViewModel> getPlayer(
            @PathVariable("id") String id) {
        var result = this.pipeline.send(new GetPlayerCommand(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<IdResponse> createPlayer(@RequestBody CreatePlayerDto dto) {
        var result = this.pipeline.send(new CreatePlayerCommand(dto.getName()));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<Void> changePlayerName(
            @RequestBody RenamePlayerDto dto,
            @PathVariable("id") String id) {
        this.pipeline.send(new RenamePlayerCommand(id, dto.getName()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(
            @PathVariable("id") String id) {
        this.pipeline.send(new DeletePlayerCommand(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
