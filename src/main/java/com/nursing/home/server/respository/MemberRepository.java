package com.nursing.home.server.respository;

import com.nursing.home.server.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);

    void deleteByUsername(String username);
}
