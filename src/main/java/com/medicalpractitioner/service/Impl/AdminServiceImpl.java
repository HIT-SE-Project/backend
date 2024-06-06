package com.medicalpractitioner.service.Impl;

import com.medicalpractitioner.mapper.AdminMapper;
import com.medicalpractitioner.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminMapper adminMapper;
    @Autowired
    public CustomServiceImpl customService;
    BCryptPasswordEncoder coder = new BCryptPasswordEncoder();
    //DONE
    @Override
    public boolean addDoctor(String account, String password) {
        int id = customService.getMaxId() + 1;
        try{
            adminMapper.insertDoctorByAccountAndPassword(account, coder.encode(password), id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //DONE
    @Override
    public boolean deleteDoctor(int doctorId) {
        try{
            adminMapper.deleteDoctorByDoctorId(doctorId);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    //DONE
    @Override
    public boolean changeRight(int refuseAppointment,int modifyInfo,int doctorId){
        try{
            adminMapper.updateDoctorRight(refuseAppointment,modifyInfo,doctorId);
            return true;
        }catch (Exception e){
        return false;
        }
    }
}
