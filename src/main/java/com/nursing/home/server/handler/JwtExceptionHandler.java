package com.nursing.home.server.handler;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JwtExceptionHandler {

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> expiredJwtExceptionHandler() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("만료된 토큰이다");
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<String> malformedJwtExceptionHandler() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지 않은 토큰입니다");
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<String> securityExceptionHandler() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("보안 예외 처리");
    }
}
