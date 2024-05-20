package com.medicalpractitioner.dto;

import lombok.Data;

@Data
public class DoctorAppointmentPackage {
    private int doctorId;
    private String date;
    private int timeId;
}
