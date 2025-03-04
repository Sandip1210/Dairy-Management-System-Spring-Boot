package com.dairy.com.dairy.management.Request;

import java.sql.Date;

import jakarta.persistence.Column;

public class AddUser {
	
public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getM_no() {
		return m_no;
	}


	public void setM_no(String m_no) {
		this.m_no = m_no;
	}


	public String getAadhar_no() {
		return aadhar_no;
	}


	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}


	public Date getBirth_date() {
		return birth_date;
	}


	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}


	public Date getJoin_date() {
		return join_date;
	}


	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


private int user_id;
	


	private String user_name;
	
	private String m_no;
	
	
	private String aadhar_no;
	
	
	private Date birth_date;
	
	
	private Date join_date;
	
	
	private String password;
	

}
