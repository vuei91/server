package com.nursing.home.server.service;

import com.nursing.home.server.dto.enroll.EnrollCUDResponse;
import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollReadResponse;

import java.util.List;

public interface EnrollService {
    List<EnrollReadResponse> getEnrolls();
    List<EnrollReadResponse> getEnrollsByHospital(Long hospitalId);
    List<EnrollReadResponse> getEnrollLsByPatient(Long patientId);
    EnrollReadResponse getEnrollByHospitalAndPatient(Long hospitalId, Long patientId);
    List<EnrollCUDResponse> createEnrolls(EnrollCreateRequest request);
    EnrollCUDResponse cancel(Long id);
    EnrollCUDResponse progress(Long id);
}
