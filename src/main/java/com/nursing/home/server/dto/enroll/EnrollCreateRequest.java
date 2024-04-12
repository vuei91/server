package com.nursing.home.server.dto.enroll;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class EnrollCreateRequest {
    private String username;
    private Long patientId;
    private Long hospitalId;
    private LocalDateTime startTime;
}
