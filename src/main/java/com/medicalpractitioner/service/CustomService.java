package com.medicalpractitioner.service;

import com.medicalpractitioner.entity.Doctor;
import com.medicalpractitioner.entity.TimeLine;

import java.util.List;

public interface CustomService {
    //用户注册功能
    public boolean userRegister(String account,String password);

    public List<TimeLine> getAllSchedule();

    public List<Doctor> queryAllDoctor();
}
