package com.study.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/hsp")
public class HttpServletResponseController {

    @GetMapping("/uuid")
    public ResponseEntity<String> helloCache(final HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("Cache-Control", "max-age=31536000");
        String randomId = UUID.randomUUID().toString();
        System.out.println("RandomUUID = " + randomId);
        return ResponseEntity.ok()
                .body(randomId);
    }

}
