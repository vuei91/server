package com.nursing.home.server.service;

import com.nursing.home.server.entity.Member;
import com.nursing.home.server.entity.Patient;

public interface MemberService {
    Member insertMember();
    Member removeMember();
    Member updateMember();
}
