package com.nearlinx.backendapi.expose.web;

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

    /**
     * Echo a message.
     *
     * @param message The message to echo. This parameter is required.
     * @return The echoed messaged.
     */
    @GetMapping("/echo")
    public String echo(@RequestParam String message) {
        return message;
    }

    /**
     * Square a number. We are assuming the number is a Double.
     * We could add some restrictions to the number of digits and fractional digits.
     *
     * @param number The number. This parameter is required.
     * @return The square of the number
     */
    @GetMapping("/square")
    public Double square(@RequestParam Double number) {
        return Math.pow(number, 2);
    }

}
