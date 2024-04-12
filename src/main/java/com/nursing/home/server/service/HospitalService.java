package com.nursing.home.server.service;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalCUDResponse;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;

public interface HospitalService {
    HospitalCUDResponse createHospital(HospitalCreateRequest request);
    HospitalCUDResponse deleteHospital(Long id);
    HospitalCUDResponse updateHospital(Long id, HospitalUpdateRequest request);
}
