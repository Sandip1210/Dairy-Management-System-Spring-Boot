package com.dairy.com.dairy.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;
	
	@Column
    private String adminId;
	
	@Column
	private String AddminPass;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdmin_Id(String admin_Id) {
		this.adminId = admin_Id;
	}

	public String getAddminPass() {
		return AddminPass;
	}

	public void setAddminPass(String addminPass) {
		AddminPass = addminPass;
	}

	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", admin_Id=" + adminId + ", AddminPass=" + AddminPass + "]";
	}

	public Admin(int aId, String admin_Id, String addminPass) {
		super();
		this.aId = aId;
		this.adminId = admin_Id;
		AddminPass = addminPass;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

}
