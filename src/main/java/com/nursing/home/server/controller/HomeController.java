package com.nursing.home.server.controller;

import com.nursing.home.server.common.ResponseCode;
import com.nursing.home.server.common.ResponseMessage;
import com.nursing.home.server.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<? super ResponseDto> home () {
        ResponseDto body = new ResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
