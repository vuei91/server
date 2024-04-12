package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollDeleteRequest;
import com.nursing.home.server.dto.enroll.EnrollResponse;
import com.nursing.home.server.dto.enroll.EnrollUpdateRequest;
import com.nursing.home.server.entity.*;
import com.nursing.home.server.exception.*;
import com.nursing.home.server.respository.*;
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
    private final RelationRepository relationRepository;

    @Override
    public EnrollResponse enroll(EnrollCreateRequest request) {
        Member member = memberRepository
                .findByUsername(request.getUsername())
                .orElseThrow(NotFoundMemberException::new);
        Hospital hospital = hospitalRepository
                .findById(request.getHospitalId())
                .orElseThrow(NotFoundHospitalException::new);
        Relation relation = relationRepository
                .findByMemberIdAndPatientId(member.getId(), request.getPatientId())
                .orElseThrow(NotFoundRelationException::new);
        Patient patient = patientRepository
                .findById(request.getPatientId())
                .orElseThrow(NotFoundPatientException::new);
        Enroll enroll = new Enroll(hospital, relation, request);
        Enroll newEnroll = enrollRepository.save(enroll);
        return new EnrollResponse(newEnroll, patient, member);
    }

    @Override
    public EnrollResponse cancel(Long id) {
        Enroll enroll = enrollRepository.findById(id).orElseThrow(NotFoundEnrollException::new);
        enroll.cancel();
        Enroll newEnroll = enrollRepository.save(enroll);
        return new EnrollResponse(newEnroll);
    }

    @Override
    public EnrollResponse progress(Long id) {
        Enroll enroll = enrollRepository.findById(id).orElseThrow(NotFoundEnrollException::new);
        enroll.progress();
        Enroll newEnroll = enrollRepository.save(enroll);
        return new EnrollResponse(newEnroll);
    }
}
