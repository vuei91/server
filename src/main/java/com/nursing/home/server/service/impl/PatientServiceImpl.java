package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.patient.PatientCreateRequest;
import com.nursing.home.server.dto.patient.PatientDeleteRequest;
import com.nursing.home.server.dto.patient.PatientResponse;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;
import com.nursing.home.server.entity.Patient;
import com.nursing.home.server.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Override
    public PatientResponse createPatient(PatientCreateRequest request) {
        return null;
    }

    @Override
    public PatientResponse deletePatient(Long id) {
        return null;
    }

    @Override
    public PatientResponse updatePatient(Long id, PatientUpdateRequest request) {
        return null;
    }
}
