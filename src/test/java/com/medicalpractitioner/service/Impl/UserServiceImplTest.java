package com.medicalpractitioner.service.Impl;

import com.medicalpractitioner.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    public UserServiceImpl userService;

    @Test
    void queryInfo() {
        System.out.println(userService.queryInfo(23));
    }

    @Test
    void updateInfo() {
        userService.updateInfo(new User(9538,"HITer",1,18,"hagd","123","123","dasdads"),9538);
    }

    @Test
    void queryRecord() {
    }
}