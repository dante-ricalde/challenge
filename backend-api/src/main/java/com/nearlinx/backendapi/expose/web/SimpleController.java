package com.nearlinx.backendapi.expose.web;

import jakarta.validation.constraints.Digits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello, welcome to the Spring Boot REST API!";
    }

    @GetMapping("/echo")
    public String echo(@RequestParam String message) {
        return message;
    }

    @GetMapping("/square")
    public Double square(@RequestParam @Digits(integer = 16, fraction = 2) Double number) {
        return Math.pow(number, 2);
    }

}
