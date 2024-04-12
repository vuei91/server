package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.member.MemberCreateRequest;
import com.nursing.home.server.dto.member.MemberCUDResponse;
import com.nursing.home.server.dto.member.MemberReadResponse;
import com.nursing.home.server.dto.member.MemberUpdateRequest;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.exception.NotFoundMemberException;
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
    public MemberReadResponse getMember(String username) {
        Member member = memberRepository.findByUsername(username).orElseThrow(NotFoundMemberException::new);
        return new MemberReadResponse(member);
    }

    @Override
    public MemberCUDResponse createMember(MemberCreateRequest request) {
        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        Member member = new Member(request);
        Member newMember = memberRepository.save(member);
        return new MemberCUDResponse(newMember);
    }

    @Override
    public MemberCUDResponse deleteMember(String username) {
        Member deleteMember = memberRepository.findByUsername(username).orElseThrow(NotFoundMemberException::new);
        memberRepository.deleteById(deleteMember.getId());
        return new MemberCUDResponse(deleteMember);
    }

    @Override
    public MemberCUDResponse updateMember(String username, MemberUpdateRequest request) {
        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        Member updateMember = memberRepository.findByUsername(username).orElseThrow(NotFoundMemberException::new);
        updateMember.update(request);
        Member updatedMember = memberRepository.save(updateMember);
        return new MemberCUDResponse(updatedMember);
    }

}
