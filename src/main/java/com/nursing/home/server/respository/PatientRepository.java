package com.nursing.home.server.respository;

import com.nursing.home.server.entity.Patient;
import com.nursing.home.server.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByRelationsIn(List<Relation> relations);
}
