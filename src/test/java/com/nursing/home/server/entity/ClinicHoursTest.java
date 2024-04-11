package com.nursing.home.server.entity;

import com.nursing.home.server.respository.ClinicHoursRepository;
import com.nursing.home.server.respository.HospitalRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@Rollback(false)
class ClinicHoursTest {

    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private ClinicHoursRepository clinicHoursRepository;
    @Test
    public void 병원등록 () {
        ClinicHours clinicHours = new ClinicHours();
        Hospital hospital = new Hospital();
        hospital.setName("병원");
        clinicHoursRepository.save(clinicHours);
        hospital.setClinicHours(clinicHours);
        hospitalRepository.save(hospital);
    }

}