package com.dairy.com.dairy.management.entity;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderDetials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	
	@Column
	private int userId;
	@Column
	private Date date;
	public OrderDetials(int orderID, int userId, Date date, int proId, String productname, int quantity, int price,
			int totalPrice, String address, String orderStatus, String ufullname) {
		super();
		this.orderID = orderID;
		this.userId = userId;
		this.date = date;
		this.proId = proId;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.address = address;
		OrderStatus = orderStatus;
		this.ufullname = ufullname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column
	private int proId;
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public OrderDetials(int orderID, int userId, int proId, String productname, int quantity, int price, int totalPrice,
			String address, String orderStatus, String ufullname) {
		super();
		this.orderID = orderID;
		this.userId = userId;
		this.proId = proId;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.address = address;
		OrderStatus = orderStatus;
		this.ufullname = ufullname;
	}

	@Override
	public String toString() {
		return "OrderDetials [orderID=" + orderID + ", userId=" + userId + ", date=" + date + ", proId=" + proId
				+ ", productname=" + productname + ", quantity=" + quantity + ", price=" + price + ", totalPrice="
				+ totalPrice + ", address=" + address + ", OrderStatus=" + OrderStatus + ", ufullname=" + ufullname
				+ "]";
	}

	public OrderDetials(int orderID, int userId, String productname, int quantity, int price, int totalPrice,
			String address, String orderStatus) {
		super();
		this.orderID = orderID;
		this.userId = userId;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.address = address;
		OrderStatus = orderStatus;
	}
	public OrderDetials() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	@Column
	private String productname;
	
	@Column
	private int quantity;
	
	@Column
	private int price ;
	
	@Column
	private int totalPrice;
	
	@Column
	private String address;
	
	@Column
	private String OrderStatus;
	
	
	@Column
	private String ufullname;


	public OrderDetials(int orderID, int userId, String productname, int quantity, int price, int totalPrice,
			String address, String orderStatus, String ufullname) {
		super();
		this.orderID = orderID;
		this.userId = userId;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.address = address;
		OrderStatus = orderStatus;
		this.ufullname = ufullname;
	}

	public String getUfullname() {
		return ufullname;
	}

	public void setUfullname(String ufullname) {
		this.ufullname = ufullname;
	}
	
	

}