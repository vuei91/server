package com.nursing.home.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
public class ClinicHours {
    @Id
    @GeneratedValue
    @Column(name = "clinic_hours_id")
    private Long id;
    @OneToOne(mappedBy = "clinicHours")
    private Hospital hospital;
    private boolean isOpenMon;
    private LocalTime monStartTime;
    private LocalTime monEndTime;
    private boolean isOpenTue;
    private LocalTime tueStartTime;
    private LocalTime tueEndTime;
    private boolean isOpenWed;
    private LocalTime wedStartTime;
    private LocalTime wedEndTime;
    private boolean isOpenThu;
    private LocalTime thuStartTime;
    private LocalTime thuEndTime;
    private boolean isOpenFri;
    private LocalTime friStartTime;
    private LocalTime friEndTime;
    private boolean isOpenSat;
    private LocalTime satStartTime;
    private LocalTime satEndTime;
    private boolean isOpenSun;
    private LocalTime sunStartTime;
    private LocalTime sunEndTime;
    private boolean isOpenHoliday;
    private LocalTime holidayStartTime;
    private LocalTime holidayEndTime;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private final LocalDateTime updatedAt = LocalDateTime.now();

    public ClinicHours () {
        this.isOpenMon = true;
        this.monStartTime = LocalTime.of(9,0,0);
        this.monEndTime = LocalTime.of(18,0,0);
        this.isOpenTue = true;
        this.tueStartTime = LocalTime.of(9,0,0);
        this.tueEndTime = LocalTime.of(18,0,0);
        this.isOpenWed = true;
        this.wedStartTime = LocalTime.of(9,0,0);
        this.wedEndTime = LocalTime.of(18,0,0);
        this.isOpenThu = true;
        this.thuStartTime = LocalTime.of(9,0,0);
        this.thuEndTime = LocalTime.of(18,0,0);
        this.isOpenFri = true;
        this.friStartTime = LocalTime.of(9,0,0);
        this.friEndTime = LocalTime.of(18,0,0);
        this.isOpenSat = true;
        this.satStartTime = LocalTime.of(9,0,0);
        this.satEndTime = LocalTime.of(12,0,0);
        this.isOpenSun = false;
        this.sunStartTime = null;
        this.sunEndTime = null;
        this.isOpenHoliday = false;
        this.holidayStartTime = null;
        this.holidayEndTime = null;
    }
}
