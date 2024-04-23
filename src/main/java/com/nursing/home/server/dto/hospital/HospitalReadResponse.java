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
    @Setter
    private List<ClinicHoursReadResponse> clinicHoursReadResponseList = new ArrayList<>();
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
    }
}
