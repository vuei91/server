package com.nursing.home.server.dto;


import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String address;
}
