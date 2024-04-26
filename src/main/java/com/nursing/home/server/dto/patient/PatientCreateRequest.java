package com.nursing.home.server.dto.patient;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientCreateRequest {
    private String name;
    private String phone;
    private String address;
    private String grade;
}
