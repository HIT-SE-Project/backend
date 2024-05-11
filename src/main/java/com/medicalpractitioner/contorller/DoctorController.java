package com.medicalpractitioner.contorller;

import com.medicalpractitioner.Utils.IdentifyID;
import com.medicalpractitioner.Utils.TimeProcessor;
import com.medicalpractitioner.entity.Doctor;
import com.medicalpractitioner.service.CustomService;
import com.medicalpractitioner.service.DoctorService;
import com.medicalpractitioner.service.Impl.CustomServiceImpl;
import com.medicalpractitioner.vo.ReturnPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @PostMapping("/api/doctor/doctorAppointment")
    public ReturnPackage doctorAppointmentStatus(@RequestParam("doctorId")int doctorId,
                                                 @RequestParam("date") String localDate,
                                                 @RequestParam("timeId") int timeId){
        LocalDate parsedDate = TimeProcessor.StrTransIntoLocalDate(localDate);
        if(doctorService.doctorAppointMent(IdentifyID.getCustomId(),
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
        if(doctorService.updateInfo(doctor,IdentifyID.getCustomId())){
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
    public ReturnPackage dealWithRecord(@RequestParam("recordIdx") int recordIdx,@RequestParam("opration") int opration){
        if(doctorService.updateRecordStatus(recordIdx,opration)){
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
}
