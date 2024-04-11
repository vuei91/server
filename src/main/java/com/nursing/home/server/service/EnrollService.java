package com.nursing.home.server.service;

import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollDeleteRequest;
import com.nursing.home.server.dto.enroll.EnrollResponse;
import com.nursing.home.server.dto.enroll.EnrollUpdateRequest;

public interface EnrollService {
    EnrollResponse createEnroll(EnrollCreateRequest request);
    EnrollResponse deleteEnroll(Long id);
    EnrollResponse updateEnroll(Long id, EnrollUpdateRequest request);
}
