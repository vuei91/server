package com.nursing.home.server.service;

import com.nursing.home.server.dto.patient.PatientCreateRequest;
import com.nursing.home.server.dto.patient.PatientCUDResponse;
import com.nursing.home.server.dto.patient.PatientReadResponse;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;

public interface PatientService {
    PatientCUDResponse createPatient(PatientCreateRequest request);
    Integer deletePatient(Long id);
    PatientCUDResponse updatePatient(Long id, PatientUpdateRequest request);
    PatientReadResponse getPatient(Long id);
}
