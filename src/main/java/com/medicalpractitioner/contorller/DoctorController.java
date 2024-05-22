package com.medicalpractitioner.contorller;

import com.medicalpractitioner.Utils.IdentifyID;
import com.medicalpractitioner.Utils.TimeProcessor;
import com.medicalpractitioner.dto.DoctorAppointmentPackage;
import com.medicalpractitioner.dto.RecordHandleInfo;
import com.medicalpractitioner.entity.Doctor;
import com.medicalpractitioner.service.CustomService;
import com.medicalpractitioner.service.DoctorService;
import com.medicalpractitioner.service.Impl.CustomServiceImpl;
import com.medicalpractitioner.vo.ReturnPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;



@RestController
public class DoctorController {
    @Autowired
    public DoctorService doctorService;

    @Autowired
    public CustomServiceImpl customService;
    @GetMapping("/api/doctor/getDoctorList")
    public ReturnPackage getDoctorList(){
        return ReturnPackage.suc(customService.queryAllDoctor());
    }

    @GetMapping("/api/doctor/getAppointmentStatus")
    public ReturnPackage getDoctorAppointmentStatus(@RequestParam("doctorId") int doctorId,
                                                    @RequestParam("date")String localDate){
        LocalDate parsedDate = TimeProcessor.StrTransIntoLocalDate(localDate);
        return ReturnPackage.suc(doctorService.getAppointmentStatus(doctorId,parsedDate));
    }

    //预约医生
    @PostMapping("/api/doctor/doctorAppointment")
    public ReturnPackage doctorAppointment(@RequestBody DoctorAppointmentPackage doctorAppointmentPackage){
        LocalDate parsedDate = TimeProcessor.StrTransIntoLocalDate(doctorAppointmentPackage.getDate());
        int userId = IdentifyID.getCustomId();
        int doctorId = doctorAppointmentPackage.getDoctorId();
        int timeId = doctorAppointmentPackage.getTimeId();
        if(doctorService.queryRcdExist(userId,doctorId,timeId,parsedDate)){
            return ReturnPackage.pack(401,"重复预约",null);
        }

        if(doctorService.doctorAppointMent(userId,
                doctorId,parsedDate,timeId)){

            return ReturnPackage.suc();
        }else{
            return ReturnPackage.fail();
        }
    }
    @GetMapping("/api/doctor/getDoctorInfo")
    //获取医生个人信息
    public ReturnPackage getDoctorInfo(){
        return ReturnPackage.suc(doctorService.queryInfo(IdentifyID.getCustomId())) ;
    }

    @PostMapping("/api/doctor/updateDoctorInfo")
    public ReturnPackage updateDoctorInfo(@RequestBody Doctor doctor){
        if(doctorService.updateInfo(doctor,doctor.getDoctorId())){
            return ReturnPackage.suc();
        }else {
            return ReturnPackage.fail();
        }
    }

    @GetMapping("/api/doctor/getRecordList")
    public ReturnPackage getMyDoctorRcdList(){
        return ReturnPackage.suc(doctorService.quaryRecord(IdentifyID.getCustomId()));
    }

    @PostMapping("/api/doctor/handleRecord")
    public ReturnPackage dealWithRecord(@RequestBody RecordHandleInfo recordHandleInfo){
        if(doctorService.updateRecordStatus(recordHandleInfo.getRecordIdx(),recordHandleInfo.getOpration())){
            return ReturnPackage.suc();
        }else{
            return ReturnPackage.fail();
        }
    }

    @GetMapping("/api/doctor/setAppointmentParams")
    public ReturnPackage setAppointmentParams(@RequestParam("patientNum") int patientNum){
       if(doctorService.updateParam(patientNum,IdentifyID.getCustomId())){
           return ReturnPackage.suc();
       }else{
           return ReturnPackage.fail();
       }
    }
    @GetMapping("/api/doctor/addDoctorTimeLine")
    public ReturnPackage addDoctorTimeLine(@RequestParam("timeId") int timeId){
        int doctorId = IdentifyID.getCustomId();
        if(doctorService.addDoctorAppointmentTimeId(timeId,doctorId)){
            return ReturnPackage.suc();
        }
        return ReturnPackage.fail();
    }

    @GetMapping("/api/doctor/deleteDoctorTimeLine")
    public ReturnPackage deleteDoctorTimeLine(@RequestParam("timeId")int timeId){
        int doctorId = IdentifyID.getCustomId();
        if(doctorService.deleteDoctorAppointmentTimeId(timeId,doctorId)){
            return ReturnPackage.suc();
        }
        return ReturnPackage.fail();
    }
}
