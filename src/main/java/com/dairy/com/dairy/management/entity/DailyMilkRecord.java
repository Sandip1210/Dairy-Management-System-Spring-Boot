package com.dairy.com.dairy.management.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
@Table(name="daily_milk_record")
public class DailyMilkRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int milk_id;
	
	@Column
	private Date date;

	@Column
	private String time;
	
	@Column
	private String uname;
	
	@Column
	private int qty;
	
	@Column
	private int fat;
	
	@Column
	private int degree;
	
	@Column
	private int rate;
	
	@Column
	private int total_rs;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private UserData user_data;
	
	
	public DailyMilkRecord() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public DailyMilkRecord(int milk_id, Date date, String time, String uname, int qty, int fat, int degree, int rate,
			int total_rs, UserData user_data) {
		super();
		this.milk_id = milk_id;
		this.date = date;
		this.time = time;
		this.uname = uname;
		this.qty = qty;
		this.fat = fat;
		this.degree = degree;
		this.rate = rate;
		this.total_rs = total_rs;
		this.user_data = user_data;
	}



	public int getMilk_id() {
		return milk_id;
	}



	@Override
	public String toString() {
		return "DailyMilkRecord [milk_id=" + milk_id + ", date=" + date + ", time=" + time + ", uname=" + uname
				+ ", qty=" + qty + ", fat=" + fat + ", degree=" + degree + ", rate=" + rate + ", total_rs=" + total_rs
				+ ", user_data=" + user_data + "]";
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



	public UserData getUser_data() {
		return user_data;
	}



	public void setUser_data(UserData user_data1) {
		this.user_data = user_data1;
	}



	
	

}
