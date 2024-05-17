package com.medicalpractitioner.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class User {

    public User(Integer userId, String name, Integer gender, Integer age, String address, String tel, String identification, String image) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.tel = tel;
        this.identification = identification;
        this.image = image;
    }

    private Integer userId;
    private String name;

    private Integer gender;
    private Integer age;

    private String address;

    private String tel;

    private String identification;

    private String image;

}
