package com.spring.useraccess_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthController {
    @GetMapping("/health")
    public String health() {
        return "Application is up the goddamn running, you will get that job Riad!";
    }
}