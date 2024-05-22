package com.medicalpractitioner.contorller;

import com.medicalpractitioner.dto.DoctorAccPsd;
import com.medicalpractitioner.dto.DoctorAuthority;
import com.medicalpractitioner.dto.DoctorId;
import com.medicalpractitioner.entity.Doctor;
import com.medicalpractitioner.mapper.CustomMapper;
import com.medicalpractitioner.service.AdminService;
import com.medicalpractitioner.service.Impl.AdminServiceImpl;
import com.medicalpractitioner.service.Impl.DoctorServiceImpl;
import com.medicalpractitioner.vo.ReturnPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdminContorller {
    @Autowired
    public CustomMapper customMapper;
    @Autowired
    public AdminServiceImpl adminService;
    @Autowired
    public DoctorServiceImpl doctorService;
    @PostMapping("/api/admin/addDoctor")
    public ReturnPackage addDoctor(@RequestBody DoctorAccPsd doctorAccPsd){
        boolean addFlag =  adminService.addDoctor(doctorAccPsd.getAccount(),doctorAccPsd.getPassword());
        if(!addFlag) {return ReturnPackage.fail();}

        int newDoctorId = customMapper.selectMaxIdNumber();
        //更新信息
        boolean updateFlag =  doctorService.updateInfo(doctorAccPsd.getDoctor(),newDoctorId);
        if(!updateFlag) {return ReturnPackage.fail();}
        return ReturnPackage.suc();
    }

    @PostMapping("/api/admin/deleteDoctor")
    public  ReturnPackage deleteDoctor(@RequestBody DoctorId doctorId){
        if(adminService.deleteDoctor(doctorId.getDoctorId())){
            return ReturnPackage.suc();
        }else{
            return ReturnPackage.fail();
        }

    }
    @PostMapping("/api/admin/setDoctorAuthority")
    public ReturnPackage setDoctorAuthority(@RequestBody DoctorAuthority doctorAuthority){
        if(adminService.changeRight(doctorAuthority.getRefuseAppointment(),
                doctorAuthority.getModifyInfo(),doctorAuthority.getDoctorId())){
            return ReturnPackage.suc();
        }else{
            return ReturnPackage.fail();
        }
    }

}
