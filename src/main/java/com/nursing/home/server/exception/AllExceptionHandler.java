package com.nursing.home.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> ResponseException () {
        System.out.println("에러란 에러는 여기에 다 걸리려나?");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }
}
