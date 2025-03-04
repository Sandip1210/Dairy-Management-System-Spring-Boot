package com.dairy.com.dairy.management.Request;

public class AdminLoginRequest {
	private String adminId;
	private String password;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminLoginRequest [adminId=" + adminId + ", password=" + password + "]";
	}

}
