package com.medicalpractitioner.service;

import com.medicalpractitioner.entity.Doctor;
import com.medicalpractitioner.entity.Record;
import com.medicalpractitioner.vo.AppointmentStatus;

import java.time.LocalDate;
import java.util.List;

public interface DoctorService {
    //查询医生个人信息
     Doctor queryInfo(int doctorId);
    //更新个人信息
     boolean updateInfo(Doctor doctor,int doctorId);
    //查询自身预约状态
     List<Record> quaryRecord(int doctorId);
    //更新权限
     boolean updateParam(int param,int doctorId);
    //预约医生
     boolean doctorAppointMent(int userId,int doctorId,LocalDate localDate,int timeId);

     //获取医生的预约情况获取时间段的最高预约人数和已经预约人数
     List<AppointmentStatus> getAppointmentStatus(int doctorId, LocalDate localDate);

    boolean updateRecordStatus(int recordIdx,int opration);
}
