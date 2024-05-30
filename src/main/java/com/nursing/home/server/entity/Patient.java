package com.nursing.home.server.entity;

import com.nursing.home.server.dto.patient.PatientCreateRequest;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Patient {
    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long id;
    private String name;
    @Column(unique = true)
    private String phone;
    private String address;
    private String latitude;
    private String longitude;
    private String grade;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private final LocalDateTime updatedAt = LocalDateTime.now();
    
    @OneToMany(mappedBy = "patient")
    List<Relation> relations = new ArrayList<>();

    public Patient(PatientCreateRequest request) {
        this.name = request.getName();
        this.phone = request.getPhone();
        this.address = request.getAddress();
        this.grade = request.getGrade();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
    }

    public void update(PatientUpdateRequest request) {
        if(request.getName() != null) this.name = request.getName();
        if(request.getAddress() != null) this.address = request.getAddress();
        if(request.getPhone() != null) this.phone = request.getPhone();
        if(request.getGrade() != null) this.grade = request.getGrade();
        if(request.getLatitude() != null) this.grade = request.getLatitude();
        if(request.getLongitude() != null) this.grade = request.getLongitude();
    }
}
