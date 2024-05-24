package com.nursing.home.server.entity;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hospital {

    @Id
    @GeneratedValue
    @Column(name="hospital_id")
    private Long id;
    // 병원이름
    private String name;
    private String category;
    // 병원전화번호
    private String tel;
    // 병원 주소
    private String address;
    // 병원 웹사이트
    private String website;
    private String subject;
    private String doctors;
    private String convenience;
    private String parking;

    @OneToMany(mappedBy = "hospital")
    private List<ClinicHours> clinicHoursList;
    // 위도
    private String latitude;
    // 경도
    private String longitude;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private LocalDateTime createdAt;
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "hospital")
    List<Enroll> enrolls;

    public Hospital(HospitalCreateRequest request) {
        this.name = request.getName();
        this.tel = request.getTel();
        this.address = request.getAddress();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
        this.category = request.getCategory();
        this.doctors = request.getDoctors();
        this.subject = request.getSubject();
        this.parking = request.getParking();
        this.convenience = request.getConvenience();
    }

    public void update(HospitalUpdateRequest request) {
        if(request.getName() != null) this.name = request.getName();
        if(request.getTel() != null) this.tel = request.getTel();
        if(request.getAddress() != null) this.address = request.getAddress();
        if(request.getLatitude() != null) this.latitude = request.getLatitude();
        if(request.getLongitude() != null) this.longitude = request.getLongitude();
        if(request.getCategory() != null) this.category = request.getCategory();
        if(request.getParking() != null) this.parking = request.getParking();
        if(request.getConvenience() != null) this.convenience = request.getConvenience();
    }
}
