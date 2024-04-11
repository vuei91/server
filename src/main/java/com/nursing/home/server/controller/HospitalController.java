package com.nursing.home.server.controller;

import com.nursing.home.server.common.ApiResponse;
import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalResponse;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;
import com.nursing.home.server.service.impl.HospitalServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalServiceImpl hospitalService;

    @PostMapping("/")
    public ApiResponse<HospitalResponse> createHospital(@RequestBody @Valid HospitalCreateRequest request) {
        return ApiResponse.ok(hospitalService.createHospital(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<HospitalResponse> updateHospital(@PathVariable Long id, @RequestBody @Valid HospitalUpdateRequest request) {
        return ApiResponse.ok(hospitalService.updateHospital(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<HospitalResponse> deleteHospital(@PathVariable Long id) {
        return ApiResponse.ok(hospitalService.deleteHospital(id));
    }
}
