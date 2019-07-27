package com.mybatis.pojo;

import java.util.Date;

public class Students 
{
	private int stut_id;
	private String email;
	private String name ;
	private Date dob;
	public int getStut_id() {
		return stut_id;
	}
	public void setStut_id(int stut_id) {
		this.stut_id = stut_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	

}
