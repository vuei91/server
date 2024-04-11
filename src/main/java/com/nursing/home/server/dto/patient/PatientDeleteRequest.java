package com.nursing.home.server.dto.patient;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PatientDeleteRequest {
    private Long id;
}
