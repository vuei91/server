package com.nursing.home.server.exception;

import com.nursing.home.server.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({NotFoundMemberException.class, NotFoundPatientException.class, NotFoundHospitalException.class, NotFoundEnrollException.class})
    public ApiResponse<String> NotFoundException(Exception e) {
        e.printStackTrace();
        return ApiResponse.fail(e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ApiResponse<String> ResponseException (Exception e) {
        e.printStackTrace();
        return ApiResponse.error(e.getMessage());
    }
}
