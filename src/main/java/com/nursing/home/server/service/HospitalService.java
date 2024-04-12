package com.nursing.home.server.service;

import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalCUDResponse;
import com.nursing.home.server.dto.hospital.HospitalReadResponse;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;

import java.util.List;

public interface HospitalService {

    List<HospitalReadResponse> getHospitals();
    HospitalCUDResponse createHospital(HospitalCreateRequest request);
    HospitalCUDResponse deleteHospital(Long id);
    HospitalCUDResponse updateHospital(Long id, HospitalUpdateRequest request);
}
