package com.nursing.home.server.dto.hospital;

import com.nursing.home.server.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class HospitalCUDResponse {
    private Long id;
    // 병원이름
    private String name;
    private String tel;
    private String category;
    // 병원주소
    private String address;
    // 진료시간
    @Setter
    private List<ClinicHoursCUDResponse> clinicHoursCUDResponseList = new ArrayList<>();
    // 위도
    private String latitude;
    // 경도
    private String longitude;
    private String convenience;
    private String parking;

    public HospitalCUDResponse(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.tel = hospital.getTel();
        this.category = hospital.getCategory();
        this.address = hospital.getAddress();
        this.latitude = hospital.getLatitude();
        this.longitude = hospital.getLongitude();
        this.convenience = hospital.getConvenience();
        this.parking = hospital.getParking();
    }


}
