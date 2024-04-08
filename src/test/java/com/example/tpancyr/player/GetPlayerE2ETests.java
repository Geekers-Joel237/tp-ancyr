package com.example.tpancyr.player;

import com.example.tpancyr.PostgreSQLTestConfiguration;
import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.model.Player;
import com.example.tpancyr.player.domain.viewmodel.PlayerViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Import(PostgreSQLTestConfiguration.class)
public class GetPlayerE2ETests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PlayerRepository repository;

    @Test
    public void ShouldGetPlayer() throws Exception {
        var existingPlayer = new Player("123", "player");
        repository.save(existingPlayer);

        var result = mockMvc
                .perform(MockMvcRequestBuilders.get("/players/" + existingPlayer.getId()))
                .andReturn();

        var viewModel = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                PlayerViewModel.class
        );

        Assertions.assertEquals(existingPlayer.getName(), viewModel.getName());
        Assertions.assertEquals(existingPlayer.getId(), viewModel.getId());
    }

}
