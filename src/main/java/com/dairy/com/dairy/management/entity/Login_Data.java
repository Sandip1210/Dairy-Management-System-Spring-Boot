package com.dairy.com.dairy.management.entity;

import org.springframework.stereotype.Component;


import jakarta.persistence.*;

@Component
@Entity
@Table(name="login_data")
public class Login_Data {

	
	
	@Override
	public String toString() {
		return "Login_Data [login_id=" + login_id + ", adharno=" + adharno + ", password=" + password + ", userdata="
				+ userdata + "]";
	}


	public Login_Data(int login_id, String adharno, String password, UserData userdata) {
		super();
		this.login_id = login_id;
		this.adharno = adharno;
		this.password = password;
		this.userdata = userdata;
	}


	public int getLogin_id() {
		return login_id;
	}


	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}


	public String getAdharno() {
		return adharno;
	}


	public void setAdharno(String adharno) {
		this.adharno = adharno;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserData getUserdata() {
		return userdata;
	}


	public void setUserdata(UserData userdata) {
		this.userdata = userdata;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int login_id;
	
	 @Column
	private String adharno;
	 
   @Column
   private String password;
   
   @OneToOne()
   @JoinColumn(name = "userdata_user_id", referencedColumnName = "user_id")
   private UserData userdata;
   
   
   public Login_Data() {
	// TODO Auto-generated constructor stub
}


}
