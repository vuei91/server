package com.nursing.home.server.entity;


import com.nursing.home.server.dto.member.MemberRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @Column(unique = true)
    private String email;
    private String name;
    @Column(unique = true)
    private String username;
    private String role;
    private String password;
    private String address;
    private String phone;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private LocalDateTime updatedAt = LocalDateTime.now();
    public Member(MemberRequest memberRequest) {
        this.email = memberRequest.getEmail();
        this.name = memberRequest.getName();
        this.address = memberRequest.getAddress();
        this.phone = memberRequest.getPhone();
        this.password = memberRequest.getPassword();
        this.username = memberRequest.getUsername();
        this.role = memberRequest.getRole();
    }
}