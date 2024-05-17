package com.medicalpractitioner.Utils;

import com.medicalpractitioner.security.MyCustomDetail;
import org.springframework.security.core.context.SecurityContextHolder;

public class IdentifyID {
    public static int getCustomId(){
        MyCustomDetail customDetail = (MyCustomDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customDetail.getCustom().getId();
    }
}
