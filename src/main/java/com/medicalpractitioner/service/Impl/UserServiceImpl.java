package com.medicalpractitioner.service.Impl;

import com.medicalpractitioner.entity.Record;
import com.medicalpractitioner.entity.User;
import com.medicalpractitioner.mapper.UserMapper;
import com.medicalpractitioner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    //Done
    @Override
    public User queryInfo(int userId) {
        //查询自身信息
        if (userId == -1) {
            return null;
        } else {
            //进行userId查询
            return userMapper.selectUserInfoById(userId);
        }
    }

    //Done
    @Override
    public boolean updateInfo(User user, int userId) {
        //更新个人信息
        try {
            userMapper.updateInfoByUser(user, userId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Record> queryRecord(int userId) {
        if (userId == -1) {
            return null;
        } else {
            return userMapper.queryRecord(userId);
        }
    }

}
