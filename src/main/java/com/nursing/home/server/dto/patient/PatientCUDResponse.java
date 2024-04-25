package com.nursing.home.server.dto.patient;

import com.nursing.home.server.entity.Patient;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientCUDResponse {
    private Long id;
    private String name;
    private String phone;
    private String grade;
    private String address;

    public PatientCUDResponse(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.phone = patient.getPhone();
        this.grade = patient.getGrade();
        this.address = patient.getAddress();
    }
}
