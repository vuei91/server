package com.nursing.home.server.controller;

import com.nursing.home.server.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth2")
public class OAuthController {
    @GetMapping("/login")
    public ResponseEntity<? super ResponseDto> login() {
        return ResponseDto.success();
    }

    @GetMapping("/logout")
    public ResponseEntity<? super ResponseDto> logout() {
        return ResponseDto.success();
    }
}
