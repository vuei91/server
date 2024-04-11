package com.nursing.home.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Hospital {

    @Id
    @GeneratedValue
    @Column(name="hospital_id")
    private Long id;
    // 병원이름
    private String name;
    // 병원주소
    private String address;
    @OneToOne
    @JoinColumn(name = "clinic_hours_id")
    private ClinicHours clinicHours;
    // 점심시작시간
    private LocalDateTime lunchStartTime;
    // 점심끝나는시간
    private LocalDateTime lunchEndTime;
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
}
