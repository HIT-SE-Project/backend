package com.medicalpractitioner.dto;

import lombok.Data;

@Data
public class DoctorAppointmentPackage {
    private int doctorId;
    private String localDate;
    private int timeId;
}
