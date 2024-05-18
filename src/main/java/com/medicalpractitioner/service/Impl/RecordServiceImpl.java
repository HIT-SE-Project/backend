package com.medicalpractitioner.service.Impl;

import com.medicalpractitioner.mapper.RecordMapper;
import com.medicalpractitioner.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    public RecordMapper recordMapper;

    @Override
    @Scheduled(fixedDelay = 300000) // 每隔5分钟执行一次 (300,000毫秒) 在上次任务完成后
    public void AutoUpdateRecordStatus(){
        recordMapper.updateRecordStatus(LocalDate.now());
    }
}
