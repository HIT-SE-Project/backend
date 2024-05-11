package com.medicalpractitioner.entity;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeLine {
    private int timeId;
    private LocalTime startTime;
    private LocalTime endTime;
}
