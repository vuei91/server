package com.nursing.home.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/oauth2")
    public ResponseEntity<?> home () {
        return new ResponseEntity(HttpStatus.OK);
    }
}
