package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalDeleteRequest;
import com.nursing.home.server.dto.hospital.HospitalResponse;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;
import com.nursing.home.server.service.HospitalService;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Override
    public HospitalResponse createHospital(HospitalCreateRequest request) {
        return null;
    }

    @Override
    public HospitalResponse deleteHospital(Long id) {
        return null;
    }

    @Override
    public HospitalResponse updateHospital(Long id, HospitalUpdateRequest request) {
        return null;
    }
}
