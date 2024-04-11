package com.nursing.home.server.entity;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
    // 병원전화번호
    private String contact;
    // 병원주소
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_hours_id")
    private ClinicHours clinicHours;
    // 점심시작시간
    private LocalTime lunchStartTime;
    // 점심끝나는시간
    private LocalTime lunchEndTime;
    // 위도
    private String latitude;
    // 경도
    private String longitude;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "hospital")
    List<Enroll> enrolls = new ArrayList<>();

    public Hospital(HospitalCreateRequest request, ClinicHours clinicHours) {
        this.name = request.getName();
        this.contact = request.getContact();
        this.address = request.getAddress();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
        this.lunchStartTime = request.getLunchStartTime();
        this.lunchEndTime = request.getLunchEndTime();
        this.clinicHours = clinicHours;
    }

    public void update(HospitalUpdateRequest request) {
        if(request.getName() != null) this.name = request.getName();
        if(request.getContact() != null) this.contact = request.getContact();
        if(request.getAddress() != null) this.address = request.getAddress();
        if(request.getLatitude() != null) this.latitude = request.getLatitude();
        if(request.getLongitude() != null) this.longitude = request.getLongitude();
        if(request.getLunchStartTime() != null) this.lunchStartTime = request.getLunchStartTime();
        if(request.getLunchEndTime() != null) this.lunchEndTime = request.getLunchEndTime();
    }
}
