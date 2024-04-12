package com.nursing.home.server.service;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.patient.PatientCreateRequest;
import com.nursing.home.server.dto.patient.PatientResponse;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;

public interface PatientService {
    PatientResponse createPatient(PatientCreateRequest request);
    PatientResponse deletePatient(Long id);
    PatientResponse updatePatient(Long id, String username, PatientUpdateRequest request);
}
