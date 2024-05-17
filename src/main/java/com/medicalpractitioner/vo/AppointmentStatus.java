package com.medicalpractitioner.vo;

import lombok.Data;

@Data
public class AppointmentStatus {
    private int timeId;
    private int patientNum;
    private int reservedNum;
}
