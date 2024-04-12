package com.nursing.home.server.dto.enroll;

import com.nursing.home.server.dto.hospital.HospitalResponse;
import com.nursing.home.server.dto.member.MemberResponse;
import com.nursing.home.server.dto.patient.PatientResponse;
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
public class EnrollResponse {
    private Long id;
    private HospitalResponse hospital;
    private PatientResponse patientResponse;
    private MemberResponse memberResponse;
    private LocalDateTime startTime;
    private Enroll.EnrollStatus status;

    public EnrollResponse(Enroll enroll, Patient patient, Member member) {
        this.id = enroll.getId();
        this.hospital = new HospitalResponse(enroll.getHospital());
        this.patientResponse = new PatientResponse(patient);
        this.memberResponse = new MemberResponse(member);
        this.startTime = enroll.getStartTime();
        this.status = enroll.getEnrollStatus();
    }

    public EnrollResponse(Enroll enroll) {
        this.id = enroll.getId();
        this.status = enroll.getEnrollStatus();
        this.startTime = enroll.getStartTime();
    }
}
