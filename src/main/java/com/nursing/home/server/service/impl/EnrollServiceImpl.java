package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.enroll.EnrollCUDResponse;
import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.dto.enroll.EnrollReadResponse;
import com.nursing.home.server.entity.*;
import com.nursing.home.server.exception.*;
import com.nursing.home.server.repository.*;
import com.nursing.home.server.service.EnrollService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollServiceImpl implements EnrollService {
    private final EnrollRepository enrollRepository;
    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;
    private final MemberRepository memberRepository;
    private final RelationRepository relationRepository;

    @Override
    public List<EnrollReadResponse> getEnrolls() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        return enrollRepository.findEnrollsByUsername(username);
    }

    @Override
    public List<EnrollReadResponse> getEnrollsByHospital(Long hospitalId) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        return enrollRepository.findEnrollsByUsernameAndHospital(username, hospitalId);
    }

    @Override
    public List<EnrollReadResponse> getEnrollLsByPatient(Long patientId) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        return enrollRepository.findEnrollsByUsernameAndPatient(username, patientId);
    }



    @Override
    public EnrollReadResponse getEnrollByHospitalAndPatient(Long hospitalId, Long patientId) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        return enrollRepository.findEnrollByUsernameAndHospitalAndPatient(username, hospitalId, patientId);
    }

    @Override
    @Transactional
    public List<EnrollCUDResponse> createEnrolls(EnrollCreateRequest request) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        List<Long> patientIds = request.getPatientIds();
        List<EnrollCUDResponse> enrolls = new ArrayList<>();
        Member member = memberRepository
                .findByUsername(username)
                .orElseThrow(NotFoundMemberException::new);
        Hospital hospital = hospitalRepository
                .findById(request.getHospitalId())
                .orElseThrow(NotFoundHospitalException::new);
        for (Long patientId : patientIds) {
            Relation relation = relationRepository
                    .findByMemberIdAndPatientId(member.getId(), patientId)
                    .orElseThrow(NotFoundRelationException::new);
            Patient patient = patientRepository
                    .findById(patientId)
                    .orElseThrow(NotFoundPatientException::new);
            Enroll enroll = new Enroll(hospital, relation, request);
            Enroll newEnroll = enrollRepository.save(enroll);
            enrolls.add(new EnrollCUDResponse(newEnroll, patient, member));
        }
        return enrolls;
    }

    @Override
    public EnrollCUDResponse cancel(Long id) {
        Enroll enroll = enrollRepository.findById(id).orElseThrow(NotFoundEnrollException::new);
        enroll.cancel();
        Enroll newEnroll = enrollRepository.save(enroll);
        return new EnrollCUDResponse(newEnroll);
    }

    @Override
    public EnrollCUDResponse progress(Long id) {
        Enroll enroll = enrollRepository.findById(id).orElseThrow(NotFoundEnrollException::new);
        enroll.progress();
        Enroll newEnroll = enrollRepository.save(enroll);
        return new EnrollCUDResponse(newEnroll);
    }
}
