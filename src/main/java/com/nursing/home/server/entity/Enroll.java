package com.nursing.home.server.entity;

import com.nursing.home.server.dto.enroll.EnrollCreateRequest;
import com.nursing.home.server.exception.ProgressCancelException;
import com.nursing.home.server.exception.ProgressFaultException;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
@Getter
public class Enroll {

    public enum EnrollStatus {
        ENROLL, CALL, CONTRACT, DEPOSIT, COMPLETE, CANCLE
    }

    @Id
    @GeneratedValue
    @Column(name = "enroll_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relation_id")
    private Relation relation;

    private LocalDateTime startTime;
    private EnrollStatus enrollStatus; // ENROLL, CALL, CONTRACT, DEPOSIT, COMPLETE

    @CreationTimestamp 
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp 
    private final LocalDateTime updatedAt = LocalDateTime.now();

    public Enroll(Hospital hospital, Relation relation, EnrollCreateRequest request) {
        this.hospital = hospital;
        this.relation = relation;
        this.startTime = request.getStartTime();
        this.enrollStatus = EnrollStatus.ENROLL;
    }

    public void cancel() {
        this.enrollStatus = EnrollStatus.CANCLE;
    }

    public void progress() {
        if(this.enrollStatus == EnrollStatus.ENROLL) {
            this.enrollStatus = EnrollStatus.CALL;
        } else if(this.enrollStatus == EnrollStatus.CALL) {
            this.enrollStatus = EnrollStatus.CONTRACT;
        } else if(this.enrollStatus == EnrollStatus.CONTRACT) {
            this.enrollStatus = EnrollStatus.DEPOSIT;
        } else if(this.enrollStatus == EnrollStatus.DEPOSIT) {
            this.enrollStatus = EnrollStatus.COMPLETE;
        } else if (this.enrollStatus == EnrollStatus.COMPLETE) {
            throw new ProgressFaultException();
        } else if(this.enrollStatus == EnrollStatus.CANCLE) {
            throw new ProgressCancelException();
        }
    }

}
