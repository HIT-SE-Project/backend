package com.medicalpractitioner.mapper;

import com.medicalpractitioner.entity.Record;
import com.medicalpractitioner.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据用户ID获取所有信息
    User selectUserInfoById(@Param("id") int userId);

    int updateInfoByUser(User user, @Param("userId") int id);

    //查询自身的所有记录
    List<Record> queryRecord(@Param("userId") int userId);

}
