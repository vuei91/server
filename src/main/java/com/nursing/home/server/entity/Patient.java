package com.nursing.home.server.entity;

import com.nursing.home.server.dto.patient.PatientCreateRequest;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Patient {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "patient_id")
    private UUID id;
    private String name;
    @Column(unique = true)
    private String phone;
    private String address;
    private String detailAddress;
    private String latitude;
    private String longitude;
    private Integer grade;
    @CreationTimestamp 
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp 
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
        this.detailAddress = request.getDetailAddress();
    }

    public void update(PatientUpdateRequest request) {
        if(request.getName() != null) this.name = request.getName();
        if(request.getAddress() != null) this.address = request.getAddress();
        if(request.getPhone() != null) this.phone = request.getPhone();
        if(request.getGrade() != null) this.grade = request.getGrade();
        if(request.getLatitude() != null) this.longitude = request.getLatitude();
        if(request.getLongitude() != null) this.longitude = request.getLongitude();
        if(request.getDetailAddress() != null) this.detailAddress = request.getDetailAddress();
    }
}
