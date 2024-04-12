package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollDeleteRequest;
import com.nursing.home.server.dto.enroll.EnrollResponse;
import com.nursing.home.server.dto.enroll.EnrollUpdateRequest;
import com.nursing.home.server.entity.Enroll;
import com.nursing.home.server.entity.Hospital;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.entity.Patient;
import com.nursing.home.server.respository.EnrollRepository;
import com.nursing.home.server.respository.HospitalRepository;
import com.nursing.home.server.respository.MemberRepository;
import com.nursing.home.server.respository.PatientRepository;
import com.nursing.home.server.service.EnrollService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollServiceImpl implements EnrollService {
    private final EnrollRepository enrollRepository;
    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;
    private final MemberRepository memberRepository;

    @Override
    public EnrollResponse createEnroll(EnrollCreateRequest request) {
        Member member = memberRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다"));
        Hospital hospital = hospitalRepository.findById(request.getHospitalId()).orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다"));
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다"));
        Enroll enroll = Enroll
                .builder()
                .member(member)
                .patient(patient)
                .hospital(hospital)
                .startTime(request.getStartTime())
                .enrollStatus(Enroll.EnrollStatus.ENROLL)
                .build();
        enrollRepository.save(enroll);
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
