package com.nursing.home.server.dto.enroll;

public interface EnrollHistoryDetailResponse {
    String getMemberName();
    String getPatientName();
    String getHospitalName();
    String getHospitalAddress();
    String getEnrollStatus();
    Long getHospitalId();
}
