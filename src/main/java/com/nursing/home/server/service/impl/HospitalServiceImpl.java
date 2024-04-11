package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.hospital.*;
import com.nursing.home.server.entity.ClinicHours;
import com.nursing.home.server.entity.Hospital;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.respository.ClinicHoursRepository;
import com.nursing.home.server.respository.HospitalRepository;
import com.nursing.home.server.service.HospitalService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ClinicHoursRepository clinicHoursRepository;
    @Override
    public HospitalResponse createHospital(HospitalCreateRequest request) {
        log.info(request.toString());
        ClinicHours clinicHours = new ClinicHours(request);
        ClinicHours newClinicHours = clinicHoursRepository.save(clinicHours);
        Hospital newHospital = new Hospital(request, newClinicHours);
        Hospital hospital = hospitalRepository.save(newHospital);
        return new HospitalResponse(hospital);
    }

    @Override
    @Transactional
    public HospitalResponse deleteHospital(Long id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 병원입니다"));
        hospitalRepository.delete(hospital);
        clinicHoursRepository.delete(hospital.getClinicHours());
        return new HospitalResponse(hospital);
    }

    @Override
    @Transactional
    public HospitalResponse updateHospital(Long id, HospitalUpdateRequest request) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 병원입니다"));
        ClinicHours updatedClinicHours = clinicHoursRepository.findById(hospital.getClinicHours().getId()).orElseThrow(() -> new RuntimeException("없는 진료시간입니다"));
        updatedClinicHours.update(request);
        clinicHoursRepository.save(updatedClinicHours);
        hospital.update(request);
        Hospital updatedHospital = hospitalRepository.save(hospital);
        return new HospitalResponse(updatedHospital);
    }
}
