package com.nursing.home.server.dto.hospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class HospitalCreateRequest {

    // 병원이름
    private String name;
    private String contact;
    // 병원주소
    private String address;
    // 점심시작시간
    private LocalTime lunchStartTime;
    // 점심끝나는시간
    private LocalTime lunchEndTime;
    // 위도
    private String latitude;
    // 경도
    private String longitude;

    // 진료시간
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
