package com.medicalpractitioner.security;

import com.medicalpractitioner.entity.Custom;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyCustomDetail implements UserDetails {
    private final Custom custom;

    public MyCustomDetail(Custom custom) {
        this.custom = custom;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return custom.getPassword();
    }

    @Override
    public String getUsername() {
        return custom.getAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Custom getCustom() {
        return custom;
    }
}
