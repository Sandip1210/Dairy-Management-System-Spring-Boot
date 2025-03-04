package com.dairy.com.dairy.management.entity;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="user_data")
public class UserData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column
	private String user_name;
	
	@Column
	private String m_no;
	
	@Column
	private String aadhar_no;
	
	@Column
	private Date birth_date;
	
	@Column
	private Date join_date;
	
	@Column
	private String password;
	
	
	@Column
	private String email;
	
    @OneToMany(mappedBy="user_data",cascade = CascadeType.ALL)
    private List<DailyMilkRecord> daily_milk_record=new ArrayList();
	
	
    @OneToMany(mappedBy="user_data",cascade = CascadeType.ALL)
    private List<PaymentHistory> payment_history=new ArrayList();
	
    @OneToOne(mappedBy = "userdata", cascade = CascadeType.ALL, orphanRemoval = true)
    private Login_Data loginData;
	
	public UserData() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "UserData [user_id=" + user_id + ", user_name=" + user_name + ", m_no=" + m_no + ", aadhar_no="
				+ aadhar_no + ", birth_date=" + birth_date + ", join_date=" + join_date + "]";
	}

	public UserData(int user_id, String user_name, String m_no, String aadhar_no, Date birth_date, Date join_date) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.m_no = m_no;
		this.aadhar_no = aadhar_no;
		this.birth_date = birth_date;
		this.join_date = join_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String  password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String  email) {
		this.email = email;
	}



}
