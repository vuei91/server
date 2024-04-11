package com.nursing.home.server.dto.patient;

import com.nursing.home.server.entity.Member;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
