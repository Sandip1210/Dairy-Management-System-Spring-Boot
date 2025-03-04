package com.dairy.com.dairy.management.Request;



import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PaymentRequest {

	private int userId;
	
	
	
	
	private Date endDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "PaymentRequest [userId=" + userId + ",  endDate=" + endDate + "]";
	}
	
	
}
