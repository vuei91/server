package com.nursing.home.server.service;

import com.nursing.home.server.dto.enroll.*;

import java.util.List;

public interface EnrollService {
    List<EnrollHistoryMainResponse> getEnrollHistoryMainList();
    List<EnrollHistoryDetailResponse> getEnrollHistoryDetail(Long patientId);
    List<EnrollReadResponse> getEnrollsByHospital(Long hospitalId);
    List<EnrollReadResponse> getEnrollLsByPatient(Long patientId);
    List<EnrollCUDResponse> createEnrolls(EnrollCreateRequest request);
    EnrollCUDResponse cancel(Long id);
    EnrollCUDResponse progress(Long id);
}
