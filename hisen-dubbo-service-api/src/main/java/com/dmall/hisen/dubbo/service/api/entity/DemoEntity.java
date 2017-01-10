package com.dmall.hisen.dubbo.service.api.entity;

import java.io.Serializable;

/**
 * Description:dubbox demo entity
 * Author:HisenSong
 * DateTime: 2017/1/10 18:15
 */

public class DemoEntity implements Serializable{

    private String name;
    private String sex;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DemoEntity(String name, String sex, String address) {
        this.name = name;
        this.sex = sex;
        this.address = address;
    }
}
