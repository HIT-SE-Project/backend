package com.medicalpractitioner.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

@Mapper
public interface RecordMapper {
    //自动更新记录时间
    void updateRecordStatus(@Param("today") LocalDate today);
}
