package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollDeleteRequest;
import com.nursing.home.server.dto.enroll.EnrollResponse;
import com.nursing.home.server.dto.enroll.EnrollUpdateRequest;
import com.nursing.home.server.service.EnrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class EnrollServiceImpl implements EnrollService {

    @Override
    public EnrollResponse createEnroll(EnrollCreateRequest request) {
        return null;
    }

    @Override
    public EnrollResponse deleteEnroll(Long id) {
        return null;
    }

    @Override
    public EnrollResponse updateEnroll(Long id, EnrollUpdateRequest request) {
        return null;
    }
}
