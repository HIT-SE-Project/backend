package com.medicalpractitioner.entity;

import lombok.Data;

@Data
public class Doctor {
    private int doctorId;
    private String name;
    private String department;
    private String title;
    private String profile;
    private String image;
    private int refuseAppointment;
    private int modifyinfo;

    public Doctor(int doctorId, String name,
                  String department, String title,
                  String profile, String image,
                  int refuseAppointment,
                  int modifyinfo) {
        this.doctorId = doctorId;
        this.name = name;
        this.department = department;
        this.title = title;
        this.profile = profile;
        this.image = image;
        this.refuseAppointment = refuseAppointment;
        this.modifyinfo = modifyinfo;
    }
}
