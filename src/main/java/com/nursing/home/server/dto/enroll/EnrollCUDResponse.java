package com.nursing.home.server.dto.enroll;

import com.nursing.home.server.dto.hospital.HospitalCUDResponse;
import com.nursing.home.server.dto.member.MemberCUDResponse;
import com.nursing.home.server.dto.patient.PatientCUDResponse;
import com.nursing.home.server.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollCUDResponse {
    private Long id;
    private HospitalCUDResponse hospital;
    private PatientCUDResponse patientCUDResponse;
    private MemberCUDResponse memberCUDResponse;
    private LocalDateTime startTime;
    private Enroll.EnrollStatus status;

    public EnrollCUDResponse(Enroll enroll, Patient patient, Member member) {
        this.id = enroll.getId();
        this.hospital = new HospitalCUDResponse(enroll.getHospital());
        this.patientCUDResponse = new PatientCUDResponse(patient);
        this.memberCUDResponse = new MemberCUDResponse(member);
        this.startTime = enroll.getStartTime();
        this.status = enroll.getEnrollStatus();
    }

    public EnrollCUDResponse(Enroll enroll) {
        this.id = enroll.getId();
        this.status = enroll.getEnrollStatus();
        this.startTime = enroll.getStartTime();
    }
}
