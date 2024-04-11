package com.nursing.home.server.controller;

import com.nursing.home.server.common.ApiResponse;
import com.nursing.home.server.dto.member.MemberCreateRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;

    @GetMapping("/")
    public ApiResponse<MemberResponse> getMembers() {
        MemberResponse response = MemberResponse.builder().id("Hello world").build();
        return ApiResponse.ok(response);
    }

}
