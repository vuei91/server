package com.nursing.home.server.repository;

import com.nursing.home.server.entity.Hospital;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    @Override
    @EntityGraph(attributePaths = {"clinicHoursList"})
    List<Hospital> findAll();
}
