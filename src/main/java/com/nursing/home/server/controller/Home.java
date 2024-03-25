package com.nursing.home.server.controller;

import com.nursing.home.server.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public UserDto home() {
        UserDto user1 = new UserDto();
        user1.setName("Hello world2");
        return user1;
    }
}
