package com.server.openMedical.controllers;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/api/")
public class Service3 {
    private final Bucket bucket;
    public Service3(){
        Bandwidth limit = Bandwidth.classic(2, Refill.greedy(2, Duration.ofSeconds(1)));
        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();
    }
    @GetMapping("service/third")
    public String getResponse(){
        return "Testing 3 service";
    }
}
