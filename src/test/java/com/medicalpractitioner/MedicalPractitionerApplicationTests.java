package com.medicalpractitioner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MedicalPractitionerApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void genEncoderPasswd(){
        System.out.println(new BCryptPasswordEncoder().encode("doctor1"));
    }
}
