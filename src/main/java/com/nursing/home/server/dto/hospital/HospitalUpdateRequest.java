package com.nursing.home.server.dto.hospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class HospitalUpdateRequest {
    private String name;
    private String tel;
    private String address;
    private String latitude;
    private String longitude;

    // 진료시간
    private Long clinicHoursId;
    private List<ClinicHoursCUDResponse> clinicHoursCUDResponseList;
}
