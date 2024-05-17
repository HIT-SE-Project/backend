package com.medicalpractitioner.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class Record {
    private int recordIdx;
    private int doctorId;
    private int userId;
    private LocalDate date;
    private int timeId;
    private int flag;
}
