package com.nursing.home.server.dto.hospital;

import com.nursing.home.server.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Builder
@AllArgsConstructor
@Getter
public class HospitalCUDResponse {
    private Long id;
    // 병원이름
    private String name;
    private String contact;
    // 병원주소
    private String address;
    // 진료시간
    private ClinicHoursCUDResponse clinicHoursCUDResponse;
    // 점심시작시간
    private LocalTime lunchStartTime;
    // 점심끝나는시간
    private LocalTime lunchEndTime;
    // 위도
    private String latitude;
    // 경도
    private String longitude;

    public HospitalCUDResponse(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.contact = hospital.getContact();
        this.address = hospital.getAddress();
        this.lunchStartTime = hospital.getLunchStartTime();
        this.lunchEndTime = hospital.getLunchEndTime();
        this.latitude = hospital.getLatitude();
        this.longitude = hospital.getLongitude();
        this.clinicHoursCUDResponse = new ClinicHoursCUDResponse(hospital.getClinicHours());
    }
}
