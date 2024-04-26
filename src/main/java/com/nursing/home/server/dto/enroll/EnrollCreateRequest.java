package com.nursing.home.server.dto.enroll;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class EnrollCreateRequest {
    private List<Long> patientIds;
    private Long hospitalId;
    private LocalDateTime startTime;
}
