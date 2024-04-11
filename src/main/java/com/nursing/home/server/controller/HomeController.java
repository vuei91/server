package com.nursing.home.server.controller;

import com.nursing.home.server.common.ResponseCode;
import com.nursing.home.server.common.ResponseMessage;
import com.nursing.home.server.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/verify")
    public ResponseEntity<? super ResponseDto> home () {
        ResponseDto body = new ResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
