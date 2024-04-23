package com.nursing.home.server.dto.hospital;

import com.nursing.home.server.entity.ClinicHours;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class ClinicHoursReadResponse {
    private Long id;
    private String weekName;
    private String weekTime;
    private String breakTime;
    private String deadlineTime;

    public ClinicHoursReadResponse(ClinicHours clinicHours) {
        this.id = clinicHours.getId();
        this.weekName = clinicHours.getWeekName();
        this.weekTime = clinicHours.getWeekTime();
        this.breakTime = clinicHours.getBreakTime();
        this.deadlineTime = clinicHours.getDeadlineTime();
    }
}
