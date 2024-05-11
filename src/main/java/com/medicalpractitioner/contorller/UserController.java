package com.medicalpractitioner.contorller;

import com.medicalpractitioner.Utils.IdentifyID;
import com.medicalpractitioner.entity.User;
import com.medicalpractitioner.mapper.UserMapper;
import com.medicalpractitioner.security.MyCustomDetail;
import com.medicalpractitioner.service.Impl.UserServiceImpl;
import com.medicalpractitioner.service.UserService;
import com.medicalpractitioner.vo.ReturnPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    public UserServiceImpl userService;


    @GetMapping("/api/user/getUserInfo")
    public ReturnPackage getUserInfo(){
        return ReturnPackage.suc(userService.queryInfo(IdentifyID.getCustomId()));
    }

    @PostMapping("/api/user/updateUserInfo")
    public ReturnPackage updateUserInfo(@RequestBody User user){
        if(userService.updateInfo(user,IdentifyID.getCustomId())){
            return ReturnPackage.suc();
        }
        return ReturnPackage.fail();
    }

    @GetMapping("/api/user/getRecordList")
    public ReturnPackage getUserRecordInfo(){
        return  ReturnPackage.suc(userService.queryRecord(IdentifyID.getCustomId()));
    }
}
