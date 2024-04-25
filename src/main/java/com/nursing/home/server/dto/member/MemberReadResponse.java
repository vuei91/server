package com.nursing.home.server.dto.member;

import com.nursing.home.server.dto.patient.PatientReadResponse;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.entity.Patient;
import com.nursing.home.server.entity.Relation;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberReadResponse {
    private String username;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String role;
    private String type;
    private List<Relation> relations;

    public MemberReadResponse(Member member) {
        this.username = member.getUsername();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.role = member.getRole();
        this.type = member.getType();
        this.relations = member.getRelations();
    }
}
