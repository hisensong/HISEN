package com.dmall.hisen.domain.entity;

import com.dmall.common.domain.BaseEntityBean;

public class StudentEntity extends BaseEntityBean {
	private java.math.BigInteger id;
	private String name;
	private Integer age;
	/**
	 * 0:男，1：女
	 */
	private String sex;
	private Integer sysVersion;
	private java.util.Date createTime;
	private java.util.Date updateTime;
	private String createUser;
	private String updateUser;
	private Integer yn;
	private java.util.Date ts;
    
	public java.math.BigInteger getId(){
		return id;
	}
	public void setId(java.math.BigInteger id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Integer getAge(){
		return age;
	}
	public void setAge(Integer age){
		this.age = age;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public Integer getSysVersion(){
		return sysVersion;
	}
	public void setSysVersion(Integer sysVersion){
		this.sysVersion = sysVersion;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	public String getCreateUser(){
		return createUser;
	}
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getUpdateUser(){
		return updateUser;
	}
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	public Integer getYn(){
		return yn;
	}
	public void setYn(Integer yn){
		this.yn = yn;
	}
	public java.util.Date getTs(){
		return ts;
	}
	public void setTs(java.util.Date ts){
		this.ts = ts;
	}
}