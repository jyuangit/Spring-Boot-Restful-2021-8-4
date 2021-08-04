package com.example.SpringBootRestful.entity;
//@Data
import org.springframework.beans.BeanUtils;

import javax.jws.soap.SOAPBinding;

public class CreateUser {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateUser(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public CreateUser() {
    }
    public static User toEmployee(CreateUser createUser) {
        User result = new User();
        BeanUtils.copyProperties(createUser, result);
        return result;
    }

}
