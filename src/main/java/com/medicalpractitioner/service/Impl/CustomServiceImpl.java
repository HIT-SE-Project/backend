package com.medicalpractitioner.service.Impl;

import com.medicalpractitioner.entity.Doctor;
import com.medicalpractitioner.entity.TimeLine;
import com.medicalpractitioner.mapper.CustomMapper;
import com.medicalpractitioner.mapper.TimeTableMapper;
import com.medicalpractitioner.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    private CustomMapper customMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private TimeTableMapper timeTableMapper;

    //Done
    @Override
    public boolean userRegister(String account, String password) {
        try {
            int id = this.getMaxId() + 1;
            // 插入数据库
            customMapper.insertUserByAccountAndPassword(id, account,
                    bCryptPasswordEncoder.encode(password));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Done
    @Override
    public List<TimeLine> getAllSchedule() {
        return timeTableMapper.selectAllTimeTableInfo();
    }

    //Done
    @Override
    public List<Doctor> queryAllDoctor() {
        return customMapper.selectAllDoctor();
    }

    //Done
    public int getMaxId() {
        Integer res = customMapper.selectMaxIdNumber();
        if (res == null) {
            return 0;
        }
        return res;
    }
}
