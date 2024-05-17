package com.medicalpractitioner.security;

import com.medicalpractitioner.entity.Custom;
import com.medicalpractitioner.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyCustomDetailService implements UserDetailsService {

    @Autowired
    private CustomMapper customMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Custom custom = customMapper.selectPasswd(username);
        if (custom == null)
            throw new UsernameNotFoundException("User not found");
        return new MyCustomDetail(custom);
    }

    public int getCustomRole(String account){
        return customMapper.selectRole(account);
    }
}