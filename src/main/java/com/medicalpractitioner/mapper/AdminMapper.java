package com.medicalpractitioner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    //id需要自己生成(自动注册医生账户和插入空的医生信息)
    boolean insertDoctorByAccountAndPassword(@Param("account") String account,
                                             @Param("password") String password,
                                             @Param("doctorId") int doctorId);
    boolean updateDoctorRight(@Param("refuseAppointment")int refuseAppointment,
                              @Param("modifyInfo")int modifyInfo,
                              @Param("doctorId") int doctorId);

    boolean deleteDoctorByDoctorId(@Param("doctorId") int doctorId);
}
