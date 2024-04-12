package com.nursing.home.server.dto.enroll;

import com.nursing.home.server.dto.hospital.HospitalCUDResponse;
import com.nursing.home.server.dto.hospital.HospitalReadResponse;
import com.nursing.home.server.dto.member.MemberCUDResponse;
import com.nursing.home.server.dto.member.MemberReadResponse;
import com.nursing.home.server.dto.patient.PatientCUDResponse;
import com.nursing.home.server.dto.patient.PatientReadResponse;
import com.nursing.home.server.entity.Enroll;

import java.time.LocalDateTime;

public class EnrollReadResponse {
    private Long id;
    private HospitalReadResponse hospital;
    private PatientReadResponse patientReadResponse;
    private MemberReadResponse memberReadResponse;
    private LocalDateTime startTime;
    private Enroll.EnrollStatus status;
}
