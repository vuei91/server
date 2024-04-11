package com.nursing.home.server.respository;

import com.nursing.home.server.entity.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepository extends JpaRepository<Enroll, Long> {
}
