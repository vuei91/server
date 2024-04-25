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
    private String grade;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private final LocalDateTime updatedAt = LocalDateTime.now();
    
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    List<Relation> relations = new ArrayList<>();

    public Patient(PatientCreateRequest request) {
        this.name = request.getName();
        this.phone = request.getPhone();
        this.address = request.getAddress();
        this.grade = request.getGrade();
    }

    public void update(PatientUpdateRequest request) {
        if(request.getName() != null) this.name = request.getName();
        if(request.getAddress() != null) this.address = request.getAddress();
        if(request.getPhone() != null) this.phone = request.getPhone();
        if(request.getGrade() != null) this.grade = request.getGrade();
    }
}
