package com.dairy.com.dairy.management.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_history")
public class PaymentHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	
	
	@Column
	private Date start_date;
	
	@Column
	private Date end_date;
	
	
	@Column
	private String name;
	
	@Column
	private double total_payment;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private UserData user_data;

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotal_payment() {
		return total_payment;
	}

	public void setTotal_payment(double total_payment) {
		this.total_payment = total_payment;
	}

	public UserData getUser_data() {
		return user_data;
	}

	public void setUser_data(UserData user_data) {
		this.user_data = user_data;
	}

	public PaymentHistory(int payment_id, Date start_date, Date end_date, String name, double total_payment,
			UserData user_data) {
		super();
		this.payment_id = payment_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.name = name;
		this.total_payment = total_payment;
		this.user_data = user_data;
	}
	
	public PaymentHistory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PaymentHistory [payment_id=" + payment_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", name=" + name + ", total_payment=" + total_payment + ", user_data=" + user_data + "]";
	}
	
	


}
