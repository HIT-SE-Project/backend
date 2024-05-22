package com.medicalpractitioner.service.Impl;

import com.medicalpractitioner.dto.Const;
import com.medicalpractitioner.entity.Doctor;
import com.medicalpractitioner.entity.Record;
import com.medicalpractitioner.mapper.DoctorMapper;
import com.medicalpractitioner.mapper.RecordMapper;
import com.medicalpractitioner.service.DoctorService;
import com.medicalpractitioner.vo.AppointmentStatus;
import com.medicalpractitioner.vo.ReturnPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private RecordMapper recordMapper;

    //Done
    @Override
    public Doctor queryInfo(int doctorId) {
        return doctorMapper.queryInfo(doctorId);
    }
    //Done
    @Override
    public boolean updateInfo(Doctor doctor, int doctorId) {
        //需要面向全局的globalhandler aop !!!
        try{
            doctorMapper.updateInfo(doctor,doctorId);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //Done
    @Override
    public List<Record> quaryRecord(int doctorId) {
        return doctorMapper.queryRecord(doctorId);
    }

    @Override
    public boolean updateParam(int param, int doctorId) {
        //先查询是否具有权限
        Doctor doctor = this.queryInfo(doctorId);
        //在controller上用注解判断权限 @preauthrize
        int modifyflag =  doctor.getModifyinfo();
        if(modifyflag > 0  ){
            //进行参数更改
            try{
                doctorMapper.updatePatientNum(param,doctorId);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        else{
            return false;
        }
    }
    //Done
    @Override
    public boolean doctorAppointMent(int userId, int doctorId,LocalDate localDate,int timeId) {
        //进行医生预约功能
        Record rcd = new Record();
        rcd.setUserId(userId);
        rcd.setDoctorId(doctorId);
        rcd.setTimeId(timeId);
        rcd.setUserId(userId);
        rcd.setDate(localDate);
        try{
            doctorMapper.insertRecord(rcd);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    //Done
    @Override
    public List<AppointmentStatus> getAppointmentStatus(int doctorId,LocalDate localDate) {
        // 获取医生的预约情况获取时间段的最高预约人数和已经预约人数
        List<Integer> timeIdList = doctorMapper.selectAValiableTimeLine(doctorId);
        List<AppointmentStatus> appointmentStatusList = new ArrayList<>();
        //  多表查询
        for (Integer timeId:
             timeIdList) {
            AppointmentStatus appointmentStatus = new AppointmentStatus();
            //获取医生的所有可用预约的timeId
            List<Record> rcdList =  doctorMapper.selectRecordByTimeIdAndDcotorIdAndDate(doctorId,timeId,localDate, Const.ACCEPT);
            int sizeList =  rcdList.size();
            appointmentStatus.setPatientNum(doctorMapper.quaryAppointmentPatientNum(doctorId));
            appointmentStatus.setTimeId(timeId);
            appointmentStatus.setReservedNum(sizeList);
            appointmentStatusList.add(appointmentStatus);
        }
        return appointmentStatusList;
    }

    //Done
    @Override
    public boolean updateRecordStatus(int recordIdx,int operation){
        // 1 代表同意 0 代表拒绝
        try{
            if(operation == 1){
                doctorMapper.updateRecordStaus(recordIdx,2);
            }else{
                doctorMapper.updateRecordStaus(recordIdx,3);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //确认记录信息是否存在
    @Override
    public boolean queryRcdExist(int userId,int doctorId,int timeId,LocalDate date){
        List<Integer> rcdIdList = recordMapper.queryRcdExist(doctorId,userId,date,timeId);
        if(rcdIdList.size() > 0 ){
            return true;
        }else {
            return false;
        }
    }

    //添加doctor的可预约时间段
    @Override
    public boolean addDoctorAppointmentTimeId(int timeId,int doctorId){
        if(doctorMapper.findDoctorTimeLine(timeId,doctorId).size() > 0){
            return false;
        }else{
            try{
                boolean res = doctorMapper.addDoctorTimeLine(timeId,doctorId);
                return res;
            }catch (Exception e){
                return false;
            }
        }
    }

    @Override
    public boolean deleteDoctorAppointmentTimeId(int timeId,int doctorId){
        try{
            boolean res = doctorMapper.deleteDoctorTimeLine(timeId,doctorId);
            return res;
        }catch (Exception e){
            return false;
        }
    }
}
