package com.nursing.home.server.dto.enroll;

public interface EnrollHistoryMainResponse {
    String getUsername();
    String getMemberName();
    Integer getPatientId();
    String getPatientName();
    String getHospitalName();
    String getEnrollStatus();
    Integer getExceptCount();
}
