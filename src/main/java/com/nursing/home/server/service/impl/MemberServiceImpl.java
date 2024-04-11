package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.member.MemberInsertRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.dto.member.MemberUpdateRequest;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.respository.MemberRepository;
import com.nursing.home.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 회원등록
    public MemberResponse insertMember(MemberInsertRequest memberInsertRequest) {
        memberInsertRequest.setPassword(bCryptPasswordEncoder.encode(memberInsertRequest.getPassword()));
        Member member = new Member(memberInsertRequest);
        Member savedMember = memberRepository.save(member);
        return new MemberResponse(savedMember);
    }
    // 회원수정
    public MemberResponse updateMember(MemberUpdateRequest memberUpdateRequest) {
        return null;
    }

    @Override
    public Member insertMember() {
        return null;
    }

    @Override
    public Member removeMember() {
        return null;
    }

    @Override
    public Member updateMember() {
        return null;
    }
}
