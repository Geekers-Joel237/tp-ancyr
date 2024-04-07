package com.example.tpancyr.player;

import com.example.tpancyr.PostgreSQLTestConfiguration;
import com.example.tpancyr.player.application.ports.PlayerRepository;
import com.example.tpancyr.player.domain.viewmodel.IdResponse;
import com.example.tpancyr.player.infrastructure.spring.CreatePlayerDto;
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
public class CreatePlayerE2ETests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PlayerRepository repository;

    @Test
    public void ShouldCreatePlayer() throws Exception {
        var dto = new CreatePlayerDto("player");

        var result = mockMvc
                .perform(MockMvcRequestBuilders.post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        var idResponse = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                IdResponse.class
        );
        var player = repository.findById(idResponse.getId());

        Assertions.assertNotNull(player);
        Assertions.assertEquals(dto.getName(), player.getName());
    }
}
