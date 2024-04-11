package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.member.MemberCreateRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.dto.member.MemberUpdateRequest;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.respository.MemberRepository;
import com.nursing.home.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public MemberResponse createMember(MemberCreateRequest request) {
        request = request.toBuilder().password(bCryptPasswordEncoder.encode(request.getPassword())).build();
        Member member = new Member(request);
        Member newMember = memberRepository.save(member);
        return new MemberResponse(newMember);
    }

    @Override
    public MemberResponse deleteMember(String username) {
        Member deleteMember = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("없는 유저입니다"));
        memberRepository.deleteById(deleteMember.getId());
        return MemberResponse.builder().username(deleteMember.getUsername()).build();
    }

    @Override
    public MemberResponse updateMember(String username, MemberUpdateRequest request) {
        Member updateMember = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("없는 유저입니다"));
        updateMember.update(request);
        updateMember.setPassword(bCryptPasswordEncoder.encode(updateMember.getPassword()));
        Member updatedMember = memberRepository.save(updateMember);
        return new MemberResponse(updatedMember);
    }

}
