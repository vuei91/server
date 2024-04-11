package com.nursing.home.server.dto.member;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberInsertRequest {
    private String id;
    private String password;
    private String type;
    private String role;
    private String name;
    private String phone;
    private String email;
    private String address;
}
