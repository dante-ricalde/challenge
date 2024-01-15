package com.nearlinx.backendapi.expose.web;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    void testEchoMessageNotProvided() throws Exception {
        mockMvc.perform(get("/api/echo"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.detail", Is.is("Required parameter 'message' is not present.")))
                .andExpect(jsonPath("$.title", Is.is("Bad Request")));
    }

    @Test
    void testSquare() throws Exception {
        mockMvc.perform(get("/api/square")
                        .param("number", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("25.0"));
    }

    @Test
    void testSquareNumberNotProvided() throws Exception {
        mockMvc.perform(get("/api/square"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.detail", Is.is("Required parameter 'number' is not present.")))
                .andExpect(jsonPath("$.title", Is.is("Bad Request")));
    }

    @Test
    void testSquareInvalidNumber() throws Exception {
        mockMvc.perform(get("/api/square")
                        .param("number", "abc"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.detail", Is.is("Parameter number must be a number.")))
                .andExpect(jsonPath("$.title", Is.is("Bad Request")));
    }

    @Test
    void testGetUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(4)))
                .andExpect(jsonPath("$[0].name", Is.is("Admin")))
                .andExpect(jsonPath("$[1].name", Is.is("User 1")))
                .andExpect(jsonPath("$[2].name", Is.is("User 2")))
                .andExpect(jsonPath("$[3].name", Is.is("User 3")));
    }
}
