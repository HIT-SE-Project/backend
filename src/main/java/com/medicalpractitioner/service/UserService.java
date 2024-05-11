package com.medicalpractitioner.service;

import com.medicalpractitioner.entity.Record;
import com.medicalpractitioner.entity.User;

import java.util.List;

public interface UserService {
    //查询个人信息
    public User queryInfo(int userId);
    //查询
    public boolean updateInfo(User user,int userId);
    //查询自身预约状态
    public List<Record> queryRecord(int userId);

}
