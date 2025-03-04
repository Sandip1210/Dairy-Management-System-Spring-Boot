package com.dairy.com.dairy.management.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int qty;
	private int price;
	private String description;
	private String imgfilename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgfilename() {
		return imgfilename;
	}
	public void setImgfilename(String imgfilename) {
		this.imgfilename = imgfilename;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + ", description="
				+ description + ", imgfilename=" + imgfilename + "]";
	}
	public Products(int id, String name, int qty, int price, String description, String imgfilename) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.description = description;
		this.imgfilename = imgfilename;
	}
	public Products() {
		// TODO Auto-generated constructor stub
	}
	public Products(String name2, int qty2, int price2, String description2, String imageName) {
		// TODO Auto-generated constructor stub
	}

}
