package com.nursing.home.server.service;

import com.nursing.home.server.dto.member.MemberCreateRequest;
import com.nursing.home.server.dto.member.MemberDeleteRequest;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.dto.member.MemberUpdateRequest;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.entity.Patient;

public interface MemberService {
    MemberResponse createMember(MemberCreateRequest request);
    MemberResponse deleteMember(String id);
    MemberResponse updateMember(String id, MemberUpdateRequest request);
}
