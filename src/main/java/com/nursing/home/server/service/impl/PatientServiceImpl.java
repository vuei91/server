package com.nursing.home.server.service.impl;

import com.nursing.home.server.dto.patient.PatientCreateRequest;
import com.nursing.home.server.dto.patient.PatientCUDResponse;
import com.nursing.home.server.dto.patient.PatientUpdateRequest;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.entity.Patient;
import com.nursing.home.server.entity.Relation;
import com.nursing.home.server.exception.NotFoundMemberException;
import com.nursing.home.server.exception.NotFoundPatientException;
import com.nursing.home.server.exception.NotFoundRelationException;
import com.nursing.home.server.respository.MemberRepository;
import com.nursing.home.server.respository.PatientRepository;
import com.nursing.home.server.respository.RelationRepository;
import com.nursing.home.server.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final MemberRepository memberRepository;
    private final PatientRepository patientRepository;
    private final RelationRepository relationRepository;

    @Override
    @Transactional
    public PatientCUDResponse createPatient(PatientCreateRequest request) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        Member member = memberRepository
                .findByUsername(username)
                .orElseThrow(NotFoundMemberException::new);
        Patient patient = new Patient(request);
        Relation relation = Relation
                .builder()
                .member(member)
                .patient(patient)
                .build();
        relationRepository.save(relation);
        Patient newPatient = patientRepository.save(patient);
        return new PatientCUDResponse(newPatient);
    }

    @Override
    @Transactional
    public PatientCUDResponse deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(NotFoundPatientException::new);
        patientRepository.delete(patient);
        return new PatientCUDResponse(patient);
    }

    @Override
    @Transactional
    public PatientCUDResponse updatePatient(Long id, String username, PatientUpdateRequest request) {
        Patient updatedPatient = patientRepository.findById(id).orElseThrow(NotFoundPatientException::new);
        if(username != null) {
            Member oldMember = memberRepository.findByUsername(username).orElseThrow(NotFoundMemberException::new);
            Member newMember = memberRepository.findByUsername(request.getMemberUsername()).orElseThrow(NotFoundMemberException::new);
            Relation relation = relationRepository.findByMemberIdAndPatientId(oldMember.getId(), updatedPatient.getId()).orElseThrow(NotFoundRelationException::new);
            relation.setMember(newMember);
            relationRepository.save(relation);
        }
        updatedPatient.update(request);
        Patient patient = patientRepository.save(updatedPatient);
        return new PatientCUDResponse(patient);
    }
}
