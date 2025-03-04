package com.dairy.com.dairy.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dairy.com.dairy.management.entity.Admin;
import com.dairy.com.dairy.management.entity.Login_Data;

public interface AdminRepo extends JpaRepository<Admin, Integer>  {
	Admin findByAdminId(String adminId);

}
