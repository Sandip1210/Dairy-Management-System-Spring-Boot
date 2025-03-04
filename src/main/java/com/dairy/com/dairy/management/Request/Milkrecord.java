package com.dairy.com.dairy.management.Request;

import java.sql.Date;

import com.dairy.com.dairy.management.entity.UserData;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Milkrecord {
private int milk_id;
	
	
	private Date date;

	
	private String time;

	private String uname;
	

	private int qty;

	private int fat;
	

	private int degree;
	

	private int rate;
	

	private int total_rs;
	
	private int userId;
	
	

	public int getMilk_id() {
		return milk_id;
	}



	



	public int getUserId() {
		return userId;
	}







	@Override
	public String toString() {
		return "Milkrecord [milk_id=" + milk_id + ", date=" + date + ", time=" + time + ", uname=" + uname + ", qty="
				+ qty + ", fat=" + fat + ", degree=" + degree + ", rate=" + rate + ", total_rs=" + total_rs
				+ ", userId=" + userId + "]";
	}







	public void setUserId(int userId) {
		this.userId = userId;
	}







	public void setMilk_id(int milk_id) {
		this.milk_id = milk_id;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public int getFat() {
		return fat;
	}



	public void setFat(int fat) {
		this.fat = fat;
	}



	public int getDegree() {
		return degree;
	}



	public void setDegree(int degree) {
		this.degree = degree;
	}



	public int getRate() {
		return rate;
	}



	public void setRate(int rate) {
		this.rate = rate;
	}



	public int getTotal_rs() {
		return total_rs;
	}



	public void setTotal_rs(int total_rs) {
		this.total_rs = total_rs;
	}



	



}
