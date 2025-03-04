package com.dairy.com.dairy.management.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="daily_dairy_record")
public class DailyDairyRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int record_id;
	
	@Column
	private Date date;
	
	@Column
	private int total_cust;
	
	@Column
	private int total_milk;
	
	@Column
	private double total_rs;

	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotal_cust() {
		return total_cust;
	}

	public void setTotal_cust(int total_cust) {
		this.total_cust = total_cust;
	}

	public int getTotal_milk() {
		return total_milk;
	}

	public void setTotal_milk(int total_milk) {
		this.total_milk = total_milk;
	}

	public double getTotal_rs() {
		return total_rs;
	}

	public void setTotal_rs(double total_rs) {
		this.total_rs = total_rs;
	}

	public DailyDairyRecord() {
		// TODO Auto-generated constructor stub
	}
	public DailyDairyRecord(int record_id, Date date, int total_cust, int total_milk, double total_rs) {
		super();
		this.record_id = record_id;
		this.date = date;
		this.total_cust = total_cust;
		this.total_milk = total_milk;
		this.total_rs = total_rs;
	}

	@Override
	public String toString() {
		return "DailyDairyRecord [record_id=" + record_id + ", date=" + date + ", total_cust=" + total_cust
				+ ", total_milk=" + total_milk + ", total_rs=" + total_rs + "]";
	}
	
	
	
	
}
