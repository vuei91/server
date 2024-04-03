package com.nursing.home.server.controller;

import com.nursing.home.server.dto.member.MemberRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberResponse> insertMember (@RequestBody MemberRequest memberRequest) {
        MemberResponse memberResponse = memberService.insertUser(memberRequest);
        return ResponseEntity.ok(memberResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
