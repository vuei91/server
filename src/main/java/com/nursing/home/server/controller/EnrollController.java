package com.nursing.home.server.controller;

import com.nursing.home.server.common.ApiResponse;
import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollResponse;
import com.nursing.home.server.dto.enroll.EnrollUpdateRequest;
import com.nursing.home.server.dto.member.MemberCreateRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.dto.member.MemberUpdateRequest;
import com.nursing.home.server.service.impl.EnrollServiceImpl;
import com.nursing.home.server.service.impl.MemberServiceImpl;
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
    public ApiResponse<EnrollResponse> createEnroll(@RequestBody @Valid EnrollCreateRequest request) {
        return ApiResponse.ok(enrollServiceImpl.createEnroll(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<EnrollResponse> updateEnroll(@PathVariable Long id, @RequestBody @Valid EnrollUpdateRequest request) {
        return ApiResponse.ok(enrollServiceImpl.updateEnroll(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<EnrollResponse> deleteEnroll(@PathVariable Long id) {
        return ApiResponse.ok(enrollServiceImpl.deleteEnroll(id));
    }
}
