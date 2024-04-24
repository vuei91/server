package com.nursing.home.server.dto.hospital;

import com.nursing.home.server.entity.Hospital;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class HospitalReadResponse {
    private Long id;
    private String name;
    private String tel;
    private String address;
    private String category;
    private String subject;
    private String doctors;
    @Setter
    private List<ClinicHoursReadResponse> clinicHoursList = new ArrayList<>();
    // 위도
    private String latitude;
    // 경도
    private String longitude;

    public HospitalReadResponse(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.tel = hospital.getTel();
        this.address = hospital.getAddress();
        this.latitude = hospital.getLatitude();
        this.longitude = hospital.getLongitude();
        this.category = hospital.getCategory();
        this.subject = hospital.getSubject();
        this.doctors = hospital.getDoctors();
        this.clinicHoursList = hospital.getClinicHoursList().stream().map(ClinicHoursReadResponse::new).toList();
    }
}
