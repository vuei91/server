package com.nursing.home.server.repository;

import com.nursing.home.server.dto.enroll.EnrollReadResponse;
import com.nursing.home.server.entity.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollRepository extends JpaRepository<Enroll, Long> {

    @Query(value =
            "select" +
                    "    e.id as enrollId," +
                    "    e.enrollStatus as enrollStatus," +
                    "    m.name as memberName," +
                    "    m.username as memberUsername," +
                    "    m.phone as memberPhone," +
                    "    m.address as memberAddress," +
                    "    p.id as patientId," +
                    "    p.name as patientName," +
                    "    p.address as patientAddress," +
                    "    p.phone as patientPhone," +
                    "    p.grade as patientGrade," +
                    "    h.id as hospitalId," +
                    "    h.name as hospitalName," +
                    "    h.address as hospitalAddress," +
                    "    h.tel as hospitalTel," +
                    "    h.website as hospitalWebsite," +
                    "    e.startTime as enrollStartTime" +
                    " from Member m" +
                    " join fetch Relation r on m = r.member" +
                    " join fetch Patient p on r.patient = p" +
                    " join fetch Enroll e on e.relation = r" +
                    " join fetch Hospital h on h = e.hospital" +
                    " where m.username = :username"
    )
    List<EnrollReadResponse> findEnrollsByUsername(String username);

    @Query(value =
            "select" +
                    "    e.id as enrollId," +
                    "    e.enrollStatus as enrollStatus," +
                    "    m.name as memberName," +
                    "    m.username as memberUsername," +
                    "    m.phone as memberPhone," +
                    "    m.address as memberAddress," +
                    "    p.id as patientId," +
                    "    p.name as patientName," +
                    "    p.address as patientAddress," +
                    "    p.phone as patientPhone," +
                    "    p.grade as patientGrade," +
                    "    h.id as hospitalId," +
                    "    h.name as hospitalName," +
                    "    h.address as hospitalAddress," +
                    "    h.tel as hospitalTel," +
                    "    h.website as hospitalWebsite," +
                    "    e.startTime as enrollStartTime" +
                    " from Member m" +
                    " join fetch Relation r on m = r.member" +
                    " join fetch Patient p on r.patient = p" +
                    " join fetch Enroll e on e.relation = r" +
                    " join fetch Hospital h on h = e.hospital" +
                    " where m.username = :username and h.id = :hospitalId"
    )
    List<EnrollReadResponse> findEnrollsByUsernameAndHospital(String username, Long hospitalId);

    @Query(value =
            "select" +
                    "    e.id as enrollId," +
                    "    e.enrollStatus as enrollStatus," +
                    "    m.name as memberName," +
                    "    m.username as memberUsername," +
                    "    m.phone as memberPhone," +
                    "    m.address as memberAddress," +
                    "    p.id as patientId," +
                    "    p.name as patientName," +
                    "    p.address as patientAddress," +
                    "    p.phone as patientPhone," +
                    "    p.grade as patientGrade," +
                    "    h.id as hospitalId," +
                    "    h.name as hospitalName," +
                    "    h.address as hospitalAddress," +
                    "    h.tel as hospitalTel," +
                    "    h.website as hospitalWebsite," +
                    "    e.startTime as enrollStartTime" +
                    " from Member m" +
                    " join fetch Relation r on m = r.member" +
                    " join fetch Patient p on r.patient = p" +
                    " join fetch Enroll e on e.relation = r" +
                    " join fetch Hospital h on h = e.hospital" +
                    " where m.username = :username and h.id = :hospitalId and p.id = :patientId"
    )
    EnrollReadResponse findEnrollByUsernameAndHospitalAndPatient(String username, Long hospitalId, Long patientId);

    @Query(value =
            "select" +
                    "    e.id as enrollId," +
                    "    e.enrollStatus as enrollStatus," +
                    "    m.name as memberName," +
                    "    m.username as memberUsername," +
                    "    m.phone as memberPhone," +
                    "    m.address as memberAddress," +
                    "    p.id as patientId," +
                    "    p.name as patientName," +
                    "    p.address as patientAddress," +
                    "    p.phone as patientPhone," +
                    "    p.grade as patientGrade," +
                    "    h.id as hospitalId," +
                    "    h.name as hospitalName," +
                    "    h.address as hospitalAddress," +
                    "    h.tel as hospitalTel," +
                    "    h.website as hospitalWebsite," +
                    "    e.startTime as enrollStartTime" +
                    " from Member m" +
                    " join fetch Relation r on m = r.member" +
                    " join fetch Patient p on r.patient = p" +
                    " join fetch Enroll e on e.relation = r" +
                    " join fetch Hospital h on h = e.hospital" +
                    " where m.username = :username and p.id = :patientId"
    )
    List<EnrollReadResponse> findEnrollsByUsernameAndPatient(String username, Long patientId);
}
