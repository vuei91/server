package com.nursing.home.server.service;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalDeleteRequest;
import com.nursing.home.server.dto.hospital.HospitalResponse;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;
import com.nursing.home.server.dto.patient.PatientDeleteRequest;
import com.nursing.home.server.dto.patient.PatientResponse;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;
import com.nursing.home.server.entity.Patient;

public interface PatientService {
    PatientResponse createPatient(HospitalCreateRequest request);
    PatientResponse deletePatient(PatientDeleteRequest request);
    PatientResponse updatePatient(PatientUpdateRequest request);
}
