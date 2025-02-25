package com.serdarselcuk.devops002pipeline.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


// http://127.0.0.1:8080/
@RestController
@RequestMapping
public class DevOpsController {

    // http://127.0.0.1:8080/
    @GetMapping
    public String devopshello() {
        return "Devops World: " + LocalDateTime.now();
    }

    // http://127.0.0.1:8080/info
    @GetMapping("/info")
    public String Info() {
        return "DEVOPS INFO : " + LocalDateTime.now();
    }

}
