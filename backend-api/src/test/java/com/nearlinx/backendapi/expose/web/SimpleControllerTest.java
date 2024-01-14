package com.nearlinx.backendapi.expose.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGreetEndpoint() throws Exception {
        mockMvc.perform(get("/api/greet"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, welcome to the Spring Boot REST API!"));
    }

    @Test
    void testEcho() throws Exception {
        mockMvc.perform(get("/api/echo")
                        .param("message", "echoing this message"))
                .andExpect(status().isOk())
                .andExpect(content().string("echoing this message"));
    }

    @Test
    void testSquare() throws Exception {
        mockMvc.perform(get("/api/square")
                        .param("number", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("25.0"));
    }
}
