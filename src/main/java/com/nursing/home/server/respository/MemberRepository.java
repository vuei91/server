package com.nursing.home.server.respository;

import com.nursing.home.server.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @EntityGraph(attributePaths = {"relations"})
    Optional<Member> findByUsername(String username);
}
