package com.medicalpractitioner.contorller;

import com.medicalpractitioner.dto.LoginInfo;
import com.medicalpractitioner.entity.Custom;
import com.medicalpractitioner.service.Impl.CustomServiceImpl;
import com.medicalpractitioner.vo.ReturnPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {
    @Autowired
    public CustomServiceImpl customService;
    @PostMapping("/api/register")
    public ReturnPackage userRegister(@RequestBody LoginInfo loginInfo){
        if(customService.userRegister(loginInfo.getAccount(),loginInfo.getPassword())){
            return  ReturnPackage.suc();
        }else{
            return ReturnPackage.fail();
        }
    }
}
