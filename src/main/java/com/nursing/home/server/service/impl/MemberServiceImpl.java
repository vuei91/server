package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.member.MemberCreateRequest;
import com.nursing.home.server.dto.member.MemberDeleteRequest;
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

    @Override
    public MemberResponse createMember(MemberCreateRequest request) {
        return null;
    }

    @Override
    public MemberResponse deleteMember(MemberDeleteRequest request) {
        return null;
    }

    @Override
    public MemberResponse updateMember(MemberUpdateRequest request) {
        return null;
    }
}
