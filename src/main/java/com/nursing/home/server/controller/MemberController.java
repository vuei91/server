package com.nursing.home.server.controller;

import com.nursing.home.server.dto.member.MemberInsertRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/")
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<MemberResponse> insertMember (@RequestBody MemberInsertRequest memberInsertRequest) {
        MemberResponse memberResponse = memberServiceImpl.insertMember(memberInsertRequest);
        return ResponseEntity.ok(memberResponse);
    }

}
