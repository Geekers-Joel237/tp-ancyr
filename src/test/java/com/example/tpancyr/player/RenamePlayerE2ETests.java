package com.example.tpancyr.player;

import com.example.tpancyr.PostgreSQLTestConfiguration;
import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.model.Player;
import com.example.tpancyr.player.infrastructure.spring.RenamePlayerDto;
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
public class RenamePlayerE2ETests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PlayerRepository repository;

    @Test
    public void ShouldRenamePlayer() throws Exception {
        var existingPlayer = new Player("123", "player");
        repository.save(existingPlayer);

        var dto = new RenamePlayerDto("player");
       mockMvc
                .perform(MockMvcRequestBuilders.patch("/players/" + existingPlayer.getId() + "/name")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        var player = repository.findById(existingPlayer.getId()).get();

        Assertions.assertNotNull(player);
        Assertions.assertEquals(dto.getName(), player.getName());
    }

    @Test
    public void ShouldFailedWhenPlayerDoesNotExist() throws Exception {

        var dto = new RenamePlayerDto("player");
        mockMvc
                .perform(MockMvcRequestBuilders.patch("/players/garbage/name")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
