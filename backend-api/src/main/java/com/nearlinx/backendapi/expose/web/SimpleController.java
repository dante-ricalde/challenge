package com.nearlinx.backendapi.expose.web;

import com.nearlinx.backendapi.model.User;
import com.nearlinx.backendapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SimpleController {

    private final UserService userService;

    @GetMapping("/greet")
    public String greet() {
        log.debug("Invoking /greet endpoint");
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
        log.debug("Invoking /echo endpoint with message '{}'", message);
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
        log.debug("Invoking /square endpoint with number '{}'", number);
        return Math.pow(number, 2);
    }

    @GetMapping("/users")
    public List<User> users() {
        log.debug("Invoking /users endpoint");
        return userService.findAll();
    }

}
