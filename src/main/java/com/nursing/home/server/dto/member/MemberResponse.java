package com.nursing.home.server.dto.member;

import com.nursing.home.server.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberResponse {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String role;
    private String type;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.role = member.getRole();
        this.type = member.getType();
    }
}
