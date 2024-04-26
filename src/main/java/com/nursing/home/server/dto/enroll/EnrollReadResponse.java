package com.nursing.home.server.dto.enroll;

import java.time.LocalDate;

public interface EnrollReadResponse {
     Long getEnrollId();
     String getEnrollStatus();
     String getMemberName();
     String getMemberUsername();
     String getMemberPhone();
     String getMemberAddress();
     Long getPatientId();
     String getPatientName();
     String getPatientAddress();
     String getPatientPhone();
     String getPatientGrade();
     Long getHospitalId();
     String getHospitalName();
     String getHospitalAddress();
     LocalDate getEnrollStartTime();
     String getHospitalTel();
     String getHospitalWebsite();
}
