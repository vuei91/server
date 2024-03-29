package com.nursing.home.server.dto.member;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    private String name;
    private String phone;
    private String email;
    private String password;
    private String address;
    private String username;
    private String role;
}
