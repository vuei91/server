package com.nursing.home.server.repository;

import com.nursing.home.server.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RelationRepository extends JpaRepository<Relation, Long> {
    Optional<Relation> findByMemberIdAndPatientId(Long memberId, Long patientId);
}
