package com.nursing.home.server.controller;

import com.nursing.home.server.dto.member.MemberRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "Hello world2";
    }

    @GetMapping("/member")
    public String main() {
        return "Hello world";
    }

    @PostMapping("/join")
    public ResponseEntity<MemberResponse> insertMember (@RequestBody MemberRequest memberRequest) {
        MemberResponse memberResponse = memberService.insertUser(memberRequest);
        return ResponseEntity.ok(memberResponse);
    }

}
