package com.medicalpractitioner.service;

import com.medicalpractitioner.entity.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    //添加删除医生
    public boolean addDoctor(String account, String password);

    public boolean deleteDoctor(int doctorId);

    //更改权限
    public boolean changeRight(int refuseAppointment,int modifyInfo,int doctorId);

}
