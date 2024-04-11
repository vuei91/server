package com.nursing.home.server.service;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalDeleteRequest;
import com.nursing.home.server.dto.hospital.HospitalResponse;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;

public interface HospitalService {
    HospitalResponse createHospital(HospitalCreateRequest request);
    HospitalResponse deleteHospital(Long id);
    HospitalResponse updateHospital(Long id, HospitalUpdateRequest request);
}
