package com.nursing.home.server.entity;


import com.nursing.home.server.dto.member.MemberRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;
    private String password;
    private String type;
    private String role;
    @Column(unique = true)
    private String email;
    private String name;
    private String phone;
    private String address;
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private final LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private final LocalDateTime updatedAt = LocalDateTime.now();
    public Member(MemberRequest memberRequest) {
        this.email = memberRequest.getEmail();
        this.name = memberRequest.getName();
        this.address = memberRequest.getAddress();
        this.phone = memberRequest.getPhone();
        this.password = memberRequest.getPassword();
        this.role = memberRequest.getRole();
        this.type = memberRequest.getType();
    }

    public Member(String id, String email, String type) {
        this.id = id;
        this.type = type;
        this.email = email;
    }

    public Member(String id, String type) {
        this.id = id;
        this.type = type;
    }
}
