package com.nursing.home.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
public class Hospital {

    @Id
    @Column(name="hospital_id")
    private Long id;
    // 병원이름
    private String name;
    // 병원주소
    private String address;
    // 진료시작시간
    private LocalDateTime openTime;
    // 진료종료시간
    private LocalDateTime closeTime;
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
}
