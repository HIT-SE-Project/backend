package com.medicalpractitioner.service.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    public AdminServiceImpl adminServices;
    @Test
    void addDoctor() {
        System.out.println(adminServices.addDoctor("doctorhit",
                new BCryptPasswordEncoder().encode("doctorhit")));
    }
    @Test
    void deleteDoctor() {
        System.out.println(adminServices.deleteDoctor(9538));
    }

    @Test
    void changeRight() {
        System.out.println(adminServices.changeRight(1,1,9537));
    }
}