package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.hospital.*;
import com.nursing.home.server.entity.ClinicHours;
import com.nursing.home.server.entity.Hospital;
import com.nursing.home.server.respository.ClinicHoursRepository;
import com.nursing.home.server.respository.HospitalRepository;
import com.nursing.home.server.service.HospitalService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        log.info(request.getClinicHoursList().toString());
        Hospital newHospital = new Hospital(request);
        Hospital hospital = hospitalRepository.save(newHospital);
        List<ClinicHoursCUDResponse> clinicHoursList = new ArrayList<>();
        List<ClinicHoursCreateRequest> clinicHoursCreateRequests = request.getClinicHoursList();
        for (ClinicHoursCreateRequest clinicHoursCreateRequest : clinicHoursCreateRequests) {
            ClinicHours clinicHours = new ClinicHours(clinicHoursCreateRequest, hospital);
            ClinicHours newClinicHours = clinicHoursRepository.save(clinicHours);
            clinicHoursList.add(new ClinicHoursCUDResponse(newClinicHours));
        }
        HospitalCUDResponse hospitalCUDResponse = new HospitalCUDResponse(hospital);
        hospitalCUDResponse.setClinicHoursCUDResponseList(clinicHoursList);
        return hospitalCUDResponse;
    }

    @Override
    @Transactional
    public HospitalCUDResponse deleteHospital(Long id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 병원입니다"));
        hospitalRepository.delete(hospital);
        return new HospitalCUDResponse(hospital);
    }

    @Override
    @Transactional
    public HospitalCUDResponse updateHospital(Long id, HospitalUpdateRequest request) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 병원입니다"));
//        ClinicHours updatedClinicHours = clinicHoursRepository.findById(hospital.getClinicHours().getId()).orElseThrow(() -> new RuntimeException("없는 진료시간입니다"));
//        updatedClinicHours.update(request);
//        clinicHoursRepository.save(updatedClinicHours);
        hospital.update(request);
        Hospital updatedHospital = hospitalRepository.save(hospital);
        return new HospitalCUDResponse(updatedHospital);
    }
}
