package com.nursing.home.server.service;

import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollResponse;

public interface EnrollService {
    EnrollResponse enroll(EnrollCreateRequest request);
    EnrollResponse cancel(Long id);
    EnrollResponse progress(Long id);
}
