package com.nursing.home.server.controller;

import com.nursing.home.server.common.ApiResponse;
import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollResponse;
import com.nursing.home.server.service.impl.EnrollServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/enroll")
@RequiredArgsConstructor
public class EnrollController {

    private final EnrollServiceImpl enrollServiceImpl;

    @PostMapping("/")
    public ApiResponse<EnrollResponse> enroll(@RequestBody @Valid EnrollCreateRequest request) {
        return ApiResponse.ok(enrollServiceImpl.enroll(request));
    }

    @PutMapping("/progress/{id}")
    public ApiResponse<EnrollResponse> progress(@PathVariable Long id) {
        return ApiResponse.ok(enrollServiceImpl.progress(id));
    }

    @PutMapping("/cancel/{id}")
    public ApiResponse<EnrollResponse> cancel(@PathVariable Long id) {
        return ApiResponse.ok(enrollServiceImpl.cancel(id));
    }
}
