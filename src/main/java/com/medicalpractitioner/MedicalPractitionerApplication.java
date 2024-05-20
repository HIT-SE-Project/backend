package com.medicalpractitioner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.medicalpractitioner.mapper")
@SpringBootApplication
@EnableScheduling

public class MedicalPractitionerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalPractitionerApplication.class, args);
    }

}
