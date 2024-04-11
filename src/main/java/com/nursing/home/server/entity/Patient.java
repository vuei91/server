package com.nursing.home.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long id;
    private String name;
    private String phone;
    private String address;
    private int grade;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private final LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "patient")
    List<Enroll> enrolls = new ArrayList<>();
}
