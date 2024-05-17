package com.medicalpractitioner.service.Impl;

import com.medicalpractitioner.entity.TimeLine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomServiceImplTest {

    @Autowired
    private CustomServiceImpl customService;
    @Test
    void getAllSchedule() {
        System.out.println(customService.getAllSchedule());
    }

    @Test
    void userRegister() {
        System.out.println(customService.userRegister("userWho","userWho"));
    }

    @Test
    void testGetAllSchedule() {
        System.out.println(customService.getAllSchedule());
    }

    @Test
    void queryAllDoctor() {
        System.out.println(customService.queryAllDoctor());
    }

    @Test
    void getMaxId() {
    }
}