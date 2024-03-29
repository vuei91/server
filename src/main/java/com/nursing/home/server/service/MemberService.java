package com.nursing.home.server.service;

import com.nursing.home.server.dto.member.MemberRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 회원등록
    public MemberResponse insertUser(MemberRequest memberRequest) {
        memberRequest.setPassword(bCryptPasswordEncoder.encode(memberRequest.getPassword()));
        Member member = new Member(memberRequest);
        Member savedMember = memberRepository.save(member);
        return new MemberResponse(savedMember);
    }
    // 회원수정

    // 회원조회
    public void getUser(MemberRequest memberRequest) {
        Member member = new Member(memberRequest);
        memberRepository.save(member);
    }
}
