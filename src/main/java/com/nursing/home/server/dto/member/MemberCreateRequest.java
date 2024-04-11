package com.nursing.home.server.dto.member;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Builder
public class MemberCreateRequest {
    @NotBlank
    private String username;
    @Setter
    private String password;
    private String type;
    private String role;
    private String name;
    @Pattern(regexp = "^\\d{2,3}\\d{3,4}\\d{4}$", message = "핸드폰 번호의 약식과 맞지 않습니다")
    private String phone;
    @Email
    private String email;
    private String address;
}
