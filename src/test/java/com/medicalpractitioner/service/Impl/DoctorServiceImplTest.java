package com.medicalpractitioner.service.Impl;

import com.medicalpractitioner.entity.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DoctorServiceImplTest {

    @Autowired
    public DoctorServiceImpl doctorService;

    @Test
    void queryInfo() {
       System.out.println(doctorService.queryInfo(9500));
    }

    @Test
    void updateInfo() {
        System.out.println(doctorService.updateInfo
                (new Doctor(9537,
                        "卢昱琦",
                        "心脏科",
                        "院士",
                        "我爱生活",
                        "dasd",
                        1,
                                1),
                        9537));
    }

    @Test
    void quaryRecord() {
        System.out.println(doctorService.quaryRecord(9536));
    }

    @Test
    void updateParam() {
    }

    @Test
    void doctorAppointMent() {
        System.out.println(doctorService.doctorAppointMent(23,2313, LocalDate.now(),4));

    }

    @Test
    void getAppointmentStatus() {
        System.out.println(doctorService.getAppointmentStatus(9536,LocalDate.now()));
    }

    @Test
    void updateRecordStatus() {
        System.out.println(doctorService.updateRecordStatus(1,1));
    }
}