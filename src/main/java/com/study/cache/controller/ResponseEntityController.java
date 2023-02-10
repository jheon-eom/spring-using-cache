package com.study.cache.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.util.UUID;

@Controller
@RequestMapping("/re")
public class ResponseEntityController {

    @GetMapping
    public void makeHttpHeader() {
        String headerValue = CacheControl.maxAge(Duration.ofDays(1))
                .cachePrivate()
                .mustRevalidate()
                .getHeaderValue();

        System.out.println("Cache-Control = " + headerValue);
    }

    @GetMapping("/cache")
    public ResponseEntity<String> makeCache() {
        CacheControl cacheControl = CacheControl.maxAge(Duration.ofDays(365));
        String randomId = UUID.randomUUID().toString();
        System.out.println("RandomUUID = " + randomId);
        return ResponseEntity.ok()
                .cacheControl(cacheControl)
                .body(randomId);
    }

    @GetMapping("/none-cache")
    public ResponseEntity<String> notCache() {
        String randomId = UUID.randomUUID().toString();
        System.out.println("RandomUUID = " + randomId);
        return ResponseEntity.ok()
                .body(randomId);
    }

    public static void main(String[] args) {
        ResponseEntityController controller = new ResponseEntityController();
        controller.makeHttpHeader();
    }

}
