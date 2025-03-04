package com.dairy.com.dairy.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dairy.com.dairy.management.entity.Login_Data;

public interface LoginRepo extends JpaRepository<Login_Data,Integer> {
	Login_Data findByAdharno(String adharno);
}
