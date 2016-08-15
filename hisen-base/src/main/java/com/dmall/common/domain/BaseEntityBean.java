//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.domain;

import com.dmall.common.domain.Criteria;
import java.util.Date;

public class BaseEntityBean extends Criteria {
    private static final long serialVersionUID = -7793739903799136331L;
    private Integer sysVersion;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;
    private Integer yn;
    private Date ts;

    public BaseEntityBean() {
    }

    public Integer getSysVersion() {
        return this.sysVersion;
    }

    public void setSysVersion(Integer sysVersion) {
        this.sysVersion = sysVersion;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getYn() {
        return this.yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public Date getTs() {
        return this.ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public BaseEntityBean init() {
        this.createUser = "";
        this.updateUser = "";
        this.yn = Integer.valueOf(1);
        return this;
    }
}
