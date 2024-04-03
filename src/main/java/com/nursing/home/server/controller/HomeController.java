package com.nursing.home.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/verify")
    public Map<String, Object> home () {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "로그인성공!");
        return map;
    }
}
