package com.nursing.home.server.dto.hospital;

import com.nursing.home.server.entity.Hospital;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class HospitalReadResponse {
    private Long id;
    private String name;
    private String contact;
    private String address;
    private ClinicHoursReadResponse clinicHoursReadResponse;
    private LocalTime lunchStartTime;
    private LocalTime lunchEndTime;
    // 위도
    private String latitude;
    // 경도
    private String longitude;

    public HospitalReadResponse(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.contact = hospital.getContact();
        this.address = hospital.getAddress();
        this.lunchStartTime = hospital.getLunchStartTime();
        this.lunchEndTime = hospital.getLunchEndTime();
        this.latitude = hospital.getLatitude();
        this.longitude = hospital.getLongitude();
        this.clinicHoursReadResponse = new ClinicHoursReadResponse(hospital.getClinicHours());
    }
}
