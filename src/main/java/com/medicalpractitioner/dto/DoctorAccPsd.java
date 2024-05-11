package com.medicalpractitioner.dto;

import com.medicalpractitioner.entity.Doctor;
import lombok.Data;


@Data
public class DoctorAccPsd {
    private int doctorId;
    private String name;
    private String department;
    private String title;
    private String profile;
    private String image;
    private int refuseAppointment;
    private int modifyinfo;

    private String account;
    private String password;

    public Doctor getDoctor(){
        Doctor doctor = new Doctor(doctorId,name,department,title,profile,image,refuseAppointment,modifyinfo);
        return doctor;
    }
}
