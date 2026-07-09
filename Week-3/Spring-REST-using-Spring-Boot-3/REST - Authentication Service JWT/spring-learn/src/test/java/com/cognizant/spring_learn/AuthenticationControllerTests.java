package com.cognizant.spring_learn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void authenticateShouldReturnTokenForValidCredentials() throws Exception {
        String basicToken = Base64.getEncoder().encodeToString("user:pwd".getBytes(StandardCharsets.UTF_8));

        mockMvc.perform(get("/authenticate").header("Authorization", "Basic " + basicToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }

    @Test
    void authenticateShouldReturnUnauthorizedForInvalidCredentials() throws Exception {
        String basicToken = Base64.getEncoder().encodeToString("user:wrong".getBytes(StandardCharsets.UTF_8));

        mockMvc.perform(get("/authenticate").header("Authorization", "Basic " + basicToken))
                .andExpect(status().isUnauthorized());
    }
}
