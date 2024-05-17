package com.medicalpractitioner.contorller;

import com.medicalpractitioner.entity.TimeLine;
import com.medicalpractitioner.service.Impl.CustomServiceImpl;
import com.medicalpractitioner.vo.ReturnPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeLineContorller {
    @Autowired
    public  CustomServiceImpl customService;

    @GetMapping("/api/doctor/getTimeTable")
    public ReturnPackage getTimeLine(){
        return  ReturnPackage.suc(customService.getAllSchedule());
    }
}
