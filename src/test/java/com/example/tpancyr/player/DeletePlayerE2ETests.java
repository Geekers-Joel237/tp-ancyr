package com.example.tpancyr.player;

import com.example.tpancyr.PostgreSQLTestConfiguration;
import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Import(PostgreSQLTestConfiguration.class)
public class DeletePlayerE2ETests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PlayerRepository repository;

    @Test
    public void ShouldDeletePlayer() throws Exception {
        var existingPlayer = new Player("123", "player");
        repository.save(existingPlayer);

        mockMvc
                .perform(MockMvcRequestBuilders.delete("/players/" + existingPlayer.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        var playerQuery = repository.findById(existingPlayer.getId());

        Assertions.assertTrue(playerQuery.isEmpty());
    }

    @Test
    public void ShouldFailedWhenPlayerDoesNotExist() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders.delete("/players/garbage")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
