package com.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/greeting")
public class GreetingsController {

    @GetMapping(value = "/say-hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from my API");
    }

    @GetMapping(value = "/say-goodbye")
    public ResponseEntity<String> sayGoodbye() {
        return ResponseEntity.ok("Goodbye and see you later");
    }
}
