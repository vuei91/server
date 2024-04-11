package com.nursing.home.server.dto.hospital;

import com.nursing.home.server.entity.ClinicHours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Map;

@Builder
@AllArgsConstructor
@Getter
public class HospitalUpdateRequest {
    private String name;
    private String contact;
    private String address;
    private LocalTime lunchStartTime;
    private LocalTime lunchEndTime;
    private String latitude;
    private String longitude;

    // 진료시간
    private Long clinicHoursId;
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
}
