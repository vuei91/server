package com.nursing.home.server.respository;

import com.nursing.home.server.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findById(String id);
}
