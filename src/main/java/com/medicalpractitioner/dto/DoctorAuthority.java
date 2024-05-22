package com.medicalpractitioner.dto;

import lombok.Data;

@Data
public class DoctorAuthority {
    private Integer doctorId;
    private Integer refuseAppointment;
    private Integer modifyInfo;
}
