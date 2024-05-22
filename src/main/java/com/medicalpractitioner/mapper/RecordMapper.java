package com.medicalpractitioner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface RecordMapper {
    //自动更新记录时间
    void updateRecordStatus(@Param("today") LocalDate today);
    List<Integer> queryRcdExist(@Param("doctorId") Integer doctorId,
                                @Param("userId") Integer userId,
                                @Param("date") LocalDate date,
                                @Param("timeId") Integer timeId);
}
