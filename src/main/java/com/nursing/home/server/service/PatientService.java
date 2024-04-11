package com.nursing.home.server.service;

import com.nursing.home.server.entity.Patient;

public interface PatientService {
    Patient insertPatient();
    Patient removePatient();
    Patient updatePatient();
}
