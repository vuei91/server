package com.nursing.home.server.respository;

import com.nursing.home.server.entity.Hospital;
import com.nursing.home.server.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {}
