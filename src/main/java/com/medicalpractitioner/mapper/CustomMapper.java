package com.medicalpractitioner.mapper;

import com.medicalpractitioner.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import com.medicalpractitioner.entity.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CustomMapper {
    Custom selectPasswd(@Param("account") String account);

    int  selectRole(@Param("account") String account);

    Custom selectById(@Param("id") int id);

    //插入用户数据
    boolean insertUserByAccountAndPassword(@Param("userId") int userId,
                                           @Param("account") String account, @Param("password") String password);

    //查询所有医生
    List<Doctor> selectAllDoctor();

    //查询最大ID
    Integer selectMaxIdNumber();
}
