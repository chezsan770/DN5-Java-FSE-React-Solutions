package com.cognizant.account;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAccountDetails() throws Exception {
        mockMvc.perform(get("/accounts/00987987973432"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value("00987987973432"))
                .andExpect(jsonPath("$.type").value("savings"))
                .andExpect(jsonPath("$.balance").value(234343));
    }
}
