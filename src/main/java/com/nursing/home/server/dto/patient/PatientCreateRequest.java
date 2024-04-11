package com.nursing.home.server.dto.patient;

import lombok.*;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientCreateRequest {
    private Long id;
    private String name;
    private String phone;
    private String address;
}
