package com.medicalpractitioner.mapper;

import com.medicalpractitioner.entity.TimeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimeTableMapper {
    List<TimeLine> selectAllTimeTableInfo();
}
