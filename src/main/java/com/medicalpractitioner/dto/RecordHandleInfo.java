package com.medicalpractitioner.dto;

import lombok.Data;

@Data
public class RecordHandleInfo {
    private int recordIdx;
    private int opration;// 0 代表拒绝 1代表同意
}
