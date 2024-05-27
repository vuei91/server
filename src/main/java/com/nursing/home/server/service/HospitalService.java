package com.nursing.home.server.service;

import com.nursing.home.server.dto.hospital.*;

import java.util.List;

public interface HospitalService {

    List<HospitalResponseForList> getHospitals();

    HospitalReadResponse getHospital(Long id);

    HospitalCUDResponse createHospital(HospitalCreateRequest request);
    HospitalCUDResponse deleteHospital(Long id);
    HospitalCUDResponse updateHospital(Long id, HospitalUpdateRequest request);
}
