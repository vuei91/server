package com.nursing.home.server.controller;

import com.nursing.home.server.common.ApiResponse;
import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollResponse;
import com.nursing.home.server.dto.enroll.EnrollUpdateRequest;
import com.nursing.home.server.dto.patient.PatientCreateRequest;
import com.nursing.home.server.dto.patient.PatientResponse;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;
import com.nursing.home.server.service.impl.EnrollServiceImpl;
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
    public ApiResponse<PatientResponse> createPatient(@RequestBody @Valid PatientCreateRequest request) {
        return ApiResponse.ok(patientServiceImpl.createPatient(request));
    }

    @PutMapping("/{id}/{username}")
    public ApiResponse<PatientResponse> updatePatient(@PathVariable Long id, @PathVariable String username, @RequestBody @Valid PatientUpdateRequest request) {
        return ApiResponse.ok(patientServiceImpl.updatePatient(id, username, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<PatientResponse> deletePatient(@PathVariable Long id) {
        return ApiResponse.ok(patientServiceImpl.deletePatient(id));
    }
}
