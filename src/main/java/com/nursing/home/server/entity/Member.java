package com.nursing.home.server.entity;


import com.nursing.home.server.dto.member.MemberCreateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "member")
    List<Enroll> enrolls = new ArrayList<>();

    public Member(MemberCreateRequest memberCreateRequest) {
        this.email = memberCreateRequest.getEmail();
        this.name = memberCreateRequest.getName();
        this.address = memberCreateRequest.getAddress();
        this.phone = memberCreateRequest.getPhone();
        this.password = memberCreateRequest.getPassword();
        this.role = memberCreateRequest.getRole();
        this.type = memberCreateRequest.getType();
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
