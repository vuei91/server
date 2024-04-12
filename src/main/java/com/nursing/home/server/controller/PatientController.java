package com.nursing.home.server.controller;

import com.nursing.home.server.common.ApiResponse;
import com.nursing.home.server.dto.patient.PatientCreateRequest;
import com.nursing.home.server.dto.patient.PatientCUDResponse;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;
import com.nursing.home.server.service.impl.PatientServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private final PatientServiceImpl patientServiceImpl;

    @PostMapping("/")
    public ApiResponse<PatientCUDResponse> createPatient(@RequestBody @Valid PatientCreateRequest request) {
        return ApiResponse.ok(patientServiceImpl.createPatient(request));
    }

    @PutMapping("/{id}/{username}")
    public ApiResponse<PatientCUDResponse> updatePatient(@PathVariable Long id, @PathVariable String username, @RequestBody @Valid PatientUpdateRequest request) {
        return ApiResponse.ok(patientServiceImpl.updatePatient(id, username, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<PatientCUDResponse> deletePatient(@PathVariable Long id) {
        return ApiResponse.ok(patientServiceImpl.deletePatient(id));
    }
}
