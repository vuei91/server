package com.nursing.home.server.dto.enroll;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EnrollCreateRequest {
    private String username;
    private Long patientId;
    private Long hospitalId;
    private LocalDateTime startTime;
    private String patientName;
    private String patientPhone;
    private String patientGrade;

}
