package com.nursing.home.server.entity;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;
import jakarta.persistence.*;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
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
    private Boolean isOpenMon;
    private LocalTime monStartTime;
    private LocalTime monEndTime;
    private Boolean isOpenTue;
    private LocalTime tueStartTime;
    private LocalTime tueEndTime;
    private Boolean isOpenWed;
    private LocalTime wedStartTime;
    private LocalTime wedEndTime;
    private Boolean isOpenThu;
    private LocalTime thuStartTime;
    private LocalTime thuEndTime;
    private Boolean isOpenFri;
    private LocalTime friStartTime;
    private LocalTime friEndTime;
    private Boolean isOpenSat;
    private LocalTime satStartTime;
    private LocalTime satEndTime;
    private Boolean isOpenSun;
    private LocalTime sunStartTime;
    private LocalTime sunEndTime;
    private Boolean isOpenHoliday;
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

    public ClinicHours (HospitalCreateRequest request) {
        this.isOpenMon = request.getIsOpenMon();
        this.monStartTime = request.getMonStartTime();
        this.monEndTime = request.getMonEndTime();
        this.isOpenTue = request.getIsOpenTue();
        this.tueStartTime = request.getTueStartTime();
        this.tueEndTime = request.getTueEndTime();
        this.isOpenWed = request.getIsOpenWed();
        this.wedStartTime = request.getWedStartTime();
        this.wedEndTime = request.getWedEndTime();
        this.isOpenThu = request.getIsOpenThu();
        this.thuStartTime = request.getThuStartTime();
        this.thuEndTime = request.getThuEndTime();
        this.isOpenFri = request.getIsOpenFri();
        this.friStartTime = request.getFriStartTime();
        this.friEndTime = request.getFriEndTime();
        this.isOpenSat = request.getIsOpenSat();
        this.satStartTime = request.getSatStartTime();
        this.satEndTime = request.getSatEndTime();
        this.isOpenSun = request.getIsOpenSun();
        this.sunStartTime = request.getSunStartTime();
        this.sunEndTime = request.getSunEndTime();
        this.isOpenHoliday = request.getIsOpenHoliday();
        this.holidayStartTime = request.getHolidayStartTime();
        this.holidayEndTime = request.getHolidayEndTime();
    }

    public void update(HospitalUpdateRequest request) {
        if(request.getIsOpenMon() != null) this.isOpenMon = request.getIsOpenMon();
        if(request.getMonStartTime() != null) this.monStartTime = request.getMonStartTime();
        if(request.getMonEndTime() != null) this.monEndTime = request.getMonEndTime();
        if(request.getIsOpenTue() != null) this.isOpenTue = request.getIsOpenTue();
        if(request.getTueStartTime() != null) this.tueStartTime = request.getTueStartTime();
        if(request.getTueEndTime() != null) this.tueEndTime = request.getTueEndTime();
        if(request.getIsOpenWed() != null) this.isOpenWed = request.getIsOpenWed();
        if(request.getWedStartTime() != null) this.wedStartTime = request.getWedStartTime();
        if(request.getWedEndTime() != null) this.wedEndTime = request.getWedEndTime();
        if(request.getIsOpenThu() != null) this.isOpenThu = request.getIsOpenThu();
        if(request.getThuStartTime() != null) this.thuStartTime = request.getThuStartTime();
        if(request.getThuEndTime() != null) this.thuEndTime = request.getThuEndTime();
        if(request.getIsOpenFri() != null) this.isOpenFri = request.getIsOpenFri();
        if(request.getFriStartTime() != null) this.friStartTime = request.getFriStartTime();
        if(request.getFriEndTime() != null) this.friEndTime = request.getFriEndTime();
        if(request.getIsOpenSat() != null) this.isOpenSat = request.getIsOpenSat();
        if(request.getSatStartTime() != null) this.satStartTime = request.getSatStartTime();
        if(request.getSatEndTime() != null) this.satEndTime = request.getSatEndTime();
        if(request.getIsOpenSun() != null) this.isOpenSun = request.getIsOpenSun();
        if(request.getSunStartTime() != null) this.sunStartTime = request.getSunStartTime();
        if(request.getSunEndTime() != null) this.sunEndTime = request.getSunEndTime();
        if(request.getIsOpenHoliday() != null) this.isOpenHoliday = request.getIsOpenHoliday();
        if(request.getHolidayStartTime() != null) this.holidayStartTime = request.getHolidayStartTime();
        if(request.getHolidayEndTime() != null) this.holidayEndTime = request.getHolidayEndTime();
    }
}
