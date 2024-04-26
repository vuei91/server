package com.nursing.home.server.controller;

import com.nursing.home.server.common.ApiResponse;
import com.nursing.home.server.dto.enroll.EnrollCUDResponse;
import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollReadResponse;
import com.nursing.home.server.service.impl.EnrollServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/enroll")
@RequiredArgsConstructor
public class EnrollController {

    private final EnrollServiceImpl enrollServiceImpl;

    @GetMapping("/")
    public ApiResponse<List<EnrollReadResponse>> getEnrolls() {
        return ApiResponse.ok(enrollServiceImpl.getEnrolls());
    }

    @GetMapping("/{hospitalId}")
    public ApiResponse<List<EnrollReadResponse>> getEnrollLsByHospital(@PathVariable Long hospitalId) {
        return ApiResponse.ok(enrollServiceImpl.getEnrollsByHospital(hospitalId));
    }

    @GetMapping("/{hospitalId}/{patientId}")
    public ApiResponse<EnrollReadResponse> getEnrollByHospitalAndPatient(@PathVariable Long hospitalId, @PathVariable Long patientId) {
        return ApiResponse.ok(enrollServiceImpl.getEnrollByHospitalAndPatient(hospitalId, patientId));
    }

    @GetMapping("/patient/{patientId}")
    public ApiResponse<List<EnrollReadResponse>> getEnrollLsByPatient(@PathVariable Long patientId) {
        return ApiResponse.ok(enrollServiceImpl.getEnrollLsByPatient(patientId));
    }

    @PostMapping("/")
    public ApiResponse<List<EnrollCUDResponse>> createEnroll(@RequestBody @Valid EnrollCreateRequest request) {
        return ApiResponse.ok(enrollServiceImpl.createEnrolls(request));
    }

    @PutMapping("/progress/{id}")
    public ApiResponse<EnrollCUDResponse> progress(@PathVariable Long id) {
        return ApiResponse.ok(enrollServiceImpl.progress(id));
    }

    @PutMapping("/cancel/{id}")
    public ApiResponse<EnrollCUDResponse> cancel(@PathVariable Long id) {
        return ApiResponse.ok(enrollServiceImpl.cancel(id));
    }
}
