package com.dairy.com.dairy.management.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dairy.com.dairy.management.Request.ChangePassword;
import com.dairy.com.dairy.management.entity.Login_Data;
import com.dairy.com.dairy.management.entity.UserData;
import com.dairy.com.dairy.management.repo.LoginRepo;
import com.dairy.com.dairy.management.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo urepo;
	
	@Autowired
	LoginRepo lrepo;
	@Autowired
	Login_Data ladata;
	
	
	
	public List<UserData> getAllUser()
	{
		
		List<UserData> li=urepo.findAll();
		return li;
		
	}
	
	public String addCustomer(UserData udata) {
		
		    // Get current date using LocalDate and convert it to java.sql.Date
		    LocalDate currentDate = LocalDate.now();
		    java.sql.Date date = java.sql.Date.valueOf(currentDate);
		
	    Optional<UserData> existingUser = urepo.findByAadhar_no(udata.getAadhar_no());
	    
	    if (existingUser.isPresent()) {
	        // Log for debugging
	        System.out.println("User with Aadhar " + udata.getAadhar_no() + " already exists.");
	        return "User already registered";
	    } 
	    else {
	    	int adhar=0;
	    	int count3=0;
	    	//Adhar number validation
			if(udata.getAadhar_no().length()==12)
			{
			for(int i=0;i<udata.getAadhar_no().length();i++)
			{
			if(udata.getAadhar_no().charAt(i)>='0' && udata.getAadhar_no().charAt(i)<='9' )
				adhar++;
			}
			}
			
			if(adhar==12)
			{
		    	udata.setJoin_date(date);
		    	urepo.save(udata); // Save new user
		        String password = udata.getPassword();
		        ladata.setAdharno(udata.getAadhar_no());
		        ladata.setPassword(password);
		        ladata.setUserdata(udata);
		        lrepo.save(ladata);
		        sendnMailToewUser(udata); // Send email after adding
		        return "User successfully added";
			}
			else
			{
				return "Please Enter valid Aadhar Number";	
			}

	    }
	}


	
	
	public UserData getUserByID(int uid)
	{
		UserData udata=urepo.findById(uid).get();
		return udata;
	}
	
	public UserData getUserByAdhaar(String adhaar)
	{
		UserData udata=urepo.findByAadhar_no(adhaar).get();
		return udata;
	}
	
	public void deleteUserById(int id )
	{
		urepo.deleteById(id);
	}
	
	
	//To send mail 
	@Value("${spring.mail.username}")
	String fromMail;
	
	@Autowired
	JavaMailSender javaMailSender;
	public void sendnMailToewUser(UserData udata)
	{
		String resiver=udata.getEmail();
		String subject="Congatulations succefully added in Sandy Dairy!!" ;
		String body=udata.getUser_name()+"your UserId is ="+udata.getUser_id()+"Password is="+udata.getPassword()+"LoginId="+udata.getAadhar_no();
	    SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
	    simpleMailMessage.setFrom(fromMail);
	    simpleMailMessage.setTo(resiver);
	    simpleMailMessage.setSubject(subject);
	    simpleMailMessage.setText(body); 
	    javaMailSender.send(simpleMailMessage);

	}
	
	
	public void updateUserById(UserData udata,int id)
	{
		UserData udata1=urepo.findById(id).get();
		Login_Data ladata1=lrepo.findById(id).get();
		
		if(udata.getAadhar_no()!=null)
		{
			udata1.setAadhar_no(udata.getAadhar_no());
			ladata1.setAdharno(udata.getAadhar_no());
		}
		if(udata.getBirth_date()!=null)
		{
			udata1.setBirth_date(udata.getBirth_date());
		}
		if(udata.getEmail()!=null)
		{
		udata1.setEmail(udata.getEmail());	
		}
		if(udata.getJoin_date()!=null)
		{
		udata1.setJoin_date(udata.getJoin_date());	
		}
		if(udata.getM_no()!=null)
		{
			udata1.setM_no(udata.getM_no());
		}
		
		if(udata.getPassword()!=null)
		{
			udata1.setPassword(udata.getPassword());
			ladata1.setPassword(udata.getPassword());
		}
		if(udata.getUser_name()!=null)
		{
			udata1.setUser_name(udata.getUser_name());
		}
		urepo.save(udata1);
		String password = udata.getPassword();
         // Set the Aadhaar number from the new user
        lrepo.save(ladata1);
	}
	
	public boolean changePassword( String oldPassword, String newPassword,int id) {
        // Find the user by username (you can customize based on your user model)
        UserData user = urepo.findById(id).get();
        
        if (user == null) {
            return false;
        }

        // Check if the old password matches the stored password (plain text comparison)
        if (user.getPassword().equals(oldPassword)) {
            // If it matches, update the password
            user.setPassword(newPassword);
            urepo.save(user);
            return true;
        
    }
        return false;
}
	
	
	public void changePasswordById(ChangePassword changepass,int id)
	{
		UserData udata1=urepo.findById(id).get();
		Login_Data ladata1=lrepo.findById(id).get();
		
		
		if(changepass.getNewPass()!=null)
		{
			udata1.setPassword(changepass.getNewPass());
			ladata1.setPassword(changepass.getNewPass());
		}
	
		urepo.save(udata1);
		
         // Set the Aadhaar number from the new user
        lrepo.save(ladata1);
	}
	

}
