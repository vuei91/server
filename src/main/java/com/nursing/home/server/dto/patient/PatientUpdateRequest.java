package com.nursing.home.server.dto.patient;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientUpdateRequest {
    private String name;
    private String phone;
    private String address;
    private Integer grade;
    private String latitude;
    private String longitude;
}
