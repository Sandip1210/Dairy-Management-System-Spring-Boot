package com.dairy.com.dairy.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.com.dairy.management.entity.Admin;
import com.dairy.com.dairy.management.entity.Login_Data;
import com.dairy.com.dairy.management.exception.InvalidAdmin;
import com.dairy.com.dairy.management.exception.InvalidPassword;
import com.dairy.com.dairy.management.exception.InvalidUser;
import com.dairy.com.dairy.management.repo.AdminRepo;
import com.dairy.com.dairy.management.repo.LoginRepo;


@Service
public class LoginService {
	@Autowired
	LoginRepo lrepo;
	
	@Autowired
	AdminRepo arepo;
	
	
	public String loginUser(String loginid, String password)
	{
	    // Find the user by Aadhaar number (loginid)
	    Login_Data data = lrepo.findByAdharno(loginid);
	    
	    if (data == null) {
	        throw new InvalidUser();  // User not found
	    }
	    
	    // Check if the password matches
	    if (data.getPassword().equals(password)) {
	        return "Successfully login";
	    } else {
	        throw new InvalidPassword();  // Incorrect password
	    }
	}

	
	public String loginAdmin(String loginid, String password)
	{
		
		 Admin data = arepo.findByAdminId(loginid);
		    
		    if (data == null) {
		    	throw new InvalidAdmin();  // User not found
		    }
		    
		    // Check if the password matches
		    if (data.getAddminPass().equals(password)) {
		        return "Successfully login";
		    } else {
		    	 throw new  InvalidPassword(); // Incorrect password
		    }
		
	}
	

}
