package com.nursing.home.server.entity;

import com.nursing.home.server.dto.hospital.ClinicHoursCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalCreateRequest;
import com.nursing.home.server.dto.hospital.HospitalUpdateRequest;
import jakarta.persistence.*;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
public class ClinicHours {
    @Id
    @GeneratedValue
    @Column(name = "clinic_hours_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
    private String weekName;
    private String weekTime;
    private String deadlineTime;
    private String breakTime;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private final LocalDateTime updatedAt = LocalDateTime.now();

    public ClinicHours () {}

    public ClinicHours (ClinicHoursCreateRequest request, Hospital hospital) {
        this.weekName = request.getWeekName();
        this.weekTime = request.getWeekTime();
        this.deadlineTime = request.getDeadlineTime();
        this.breakTime = request.getBreakTime();
        this.hospital = hospital;
    }

    public void update(HospitalUpdateRequest request) {

    }
}
