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

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ClinicHoursRepository clinicHoursRepository;

    @Override
    public List<HospitalReadResponse> getHospitals() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        return hospitals
                .stream()
                .map(HospitalReadResponse::new)
                .toList();
    }

    @Override
    public HospitalCUDResponse createHospital(HospitalCreateRequest request) {
        log.info(request.toString());
        ClinicHours clinicHours = new ClinicHours(request);
        ClinicHours newClinicHours = clinicHoursRepository.save(clinicHours);
        Hospital newHospital = new Hospital(request, newClinicHours);
        Hospital hospital = hospitalRepository.save(newHospital);
        return new HospitalCUDResponse(hospital);
    }

    @Override
    @Transactional
    public HospitalCUDResponse deleteHospital(Long id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 병원입니다"));
        hospitalRepository.delete(hospital);
        clinicHoursRepository.delete(hospital.getClinicHours());
        return new HospitalCUDResponse(hospital);
    }

    @Override
    @Transactional
    public HospitalCUDResponse updateHospital(Long id, HospitalUpdateRequest request) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 병원입니다"));
        ClinicHours updatedClinicHours = clinicHoursRepository.findById(hospital.getClinicHours().getId()).orElseThrow(() -> new RuntimeException("없는 진료시간입니다"));
        updatedClinicHours.update(request);
        clinicHoursRepository.save(updatedClinicHours);
        hospital.update(request);
        Hospital updatedHospital = hospitalRepository.save(hospital);
        return new HospitalCUDResponse(updatedHospital);
    }
}
