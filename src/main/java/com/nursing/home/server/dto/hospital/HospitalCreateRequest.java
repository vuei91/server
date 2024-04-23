package com.nursing.home.server.dto.hospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class HospitalCreateRequest {

    // 병원이름
    private String name;
    private String tel;
    // 병원주소
    private String address;
    // 점심시작시간
    private LocalTime lunchStartTime;
    // 점심끝나는시간
    private LocalTime lunchEndTime;
    // 위도
    private String latitude;
    // 경도
    private String longitude;
    // 진료시간
    private List<ClinicHoursCreateRequest> clinicHoursList;
}
