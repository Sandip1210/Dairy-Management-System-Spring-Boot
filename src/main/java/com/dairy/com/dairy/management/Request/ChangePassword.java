package com.dairy.com.dairy.management.Request;

public class ChangePassword {
	
	private String oldPass;
	private String newPass;
	private int uId;
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	@Override
	public String toString() {
		return "ChangePassword [oldPass=" + oldPass + ", newPass=" + newPass + ", uId=" + uId + "]";
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}

}
