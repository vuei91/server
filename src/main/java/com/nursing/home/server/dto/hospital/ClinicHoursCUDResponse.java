package com.nursing.home.server.dto.hospital;

import com.nursing.home.server.entity.ClinicHours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
@Builder
public class ClinicHoursCUDResponse {
    private Long id;
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

    public ClinicHoursCUDResponse(ClinicHours clinicHours) {
        this.id = clinicHours.getId();
        this.isOpenMon = clinicHours.getIsOpenMon();
        this.monStartTime = clinicHours.getMonStartTime();
        this.monEndTime = clinicHours.getMonEndTime();
        this.isOpenTue = clinicHours.getIsOpenTue();
        this.tueStartTime = clinicHours.getTueStartTime();
        this.tueEndTime = clinicHours.getTueEndTime();
        this.isOpenWed = clinicHours.getIsOpenWed();
        this.wedStartTime = clinicHours.getWedStartTime();
        this.wedEndTime = clinicHours.getWedEndTime();
        this.isOpenThu = clinicHours.getIsOpenThu();
        this.thuStartTime = clinicHours.getThuStartTime();
        this.thuEndTime = clinicHours.getThuEndTime();
        this.isOpenFri = clinicHours.getIsOpenFri();
        this.friStartTime = clinicHours.getFriStartTime();
        this.friEndTime = clinicHours.getFriEndTime();
        this.isOpenSat = clinicHours.getIsOpenSat();
        this.satStartTime = clinicHours.getSatStartTime();
        this.satEndTime = clinicHours.getSatEndTime();
        this.isOpenSun = clinicHours.getIsOpenSun();
        this.sunStartTime = clinicHours.getSunStartTime();
        this.sunEndTime = clinicHours.getSunEndTime();
        this.isOpenHoliday = clinicHours.getIsOpenHoliday();
        this.holidayStartTime = clinicHours.getHolidayStartTime();
        this.holidayEndTime = clinicHours.getHolidayEndTime();
    }
}
