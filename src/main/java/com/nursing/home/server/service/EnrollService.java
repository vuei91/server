package com.nursing.home.server.service;

import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollCUDResponse;

public interface EnrollService {
    EnrollCUDResponse enroll(EnrollCreateRequest request);
    EnrollCUDResponse cancel(Long id);
    EnrollCUDResponse progress(Long id);
}
