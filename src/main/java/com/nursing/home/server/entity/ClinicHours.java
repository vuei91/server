package com.nursing.home.server.entity;

import com.nursing.home.server.dto.hospital.ClinicHoursCreateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClinicHours {
    @Id
    @GeneratedValue
    @Column(name = "clinic_hours_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
    private String weekName;
    private String weekTime;
    private String deadlineTime;
    private String breakTime;
    @CreationTimestamp 
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp 
    private final LocalDateTime updatedAt = LocalDateTime.now();

    public ClinicHours (ClinicHoursCreateRequest request, Hospital hospital) {
        this.weekName = request.getWeekName();
        this.weekTime = request.getWeekTime();
        this.deadlineTime = request.getDeadlineTime();
        this.breakTime = request.getBreakTime();
        this.hospital = hospital;
    }
}
