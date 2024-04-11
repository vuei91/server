package com.nursing.home.server.entity;


import com.nursing.home.server.dto.member.MemberInsertRequest;
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
@Setter
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

    @OneToMany(mappedBy = "member")
    List<Enroll> enrolls = new ArrayList<>();

    public Member(MemberInsertRequest memberInsertRequest) {
        this.email = memberInsertRequest.getEmail();
        this.name = memberInsertRequest.getName();
        this.address = memberInsertRequest.getAddress();
        this.phone = memberInsertRequest.getPhone();
        this.password = memberInsertRequest.getPassword();
        this.role = memberInsertRequest.getRole();
        this.type = memberInsertRequest.getType();
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
