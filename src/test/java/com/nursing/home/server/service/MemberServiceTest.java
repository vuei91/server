package com.nursing.home.server.service;

import com.nursing.home.server.dto.member.MemberRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@Transactional
@SpringBootTest
@Rollback(false)
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Test
    public void 회원등록(){
        MemberRequest memberRequest = new MemberRequest();
        memberRequest.setName("박의");
        memberRequest.setPhone("010-1234-1234");
        memberRequest.setEmail("abc@naver.com");
        memberRequest.setPassword("12341234");
        MemberResponse savedMember = memberService.insertUser(memberRequest);
        System.out.println("Hello world");
        System.out.println(savedMember.toString());
    }
}