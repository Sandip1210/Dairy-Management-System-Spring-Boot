package com.dairy.com.dairy.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dairy.com.dairy.management.Request.AdminLoginRequest;
import com.dairy.com.dairy.management.Request.ChangePassword;
import com.dairy.com.dairy.management.Request.UserRequest;
import com.dairy.com.dairy.management.entity.DailyMilkRecord;
import com.dairy.com.dairy.management.entity.Login_Data;
import com.dairy.com.dairy.management.entity.PaymentHistory;
import com.dairy.com.dairy.management.entity.UserData;
import com.dairy.com.dairy.management.service.DailyDairyRecordService;
import com.dairy.com.dairy.management.service.DailyMilkRecordService;
import com.dairy.com.dairy.management.service.LoginService;
import com.dairy.com.dairy.management.service.PaymentService;
import com.dairy.com.dairy.management.service.UserService;

@Controller
public class LoginController {
	@Autowired
	LoginService lservice;

	@PostMapping("userlogin/{lid}/{pass}")
	public ResponseEntity<String>  makeLoginUser(@PathVariable String lid,@PathVariable String pass)
	{
		try {
		String result = lservice.loginUser(lid,pass);
		return new ResponseEntity<String>(result, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/adminlogin1")
	public String  makeAdminLogin(@ModelAttribute AdminLoginRequest adminLogin,Model model,RedirectAttributes redirectAttributes)
	{
		try {
		String result = lservice.loginAdmin(adminLogin.getAdminId(),adminLogin.getPassword());
		System.out.println(adminLogin);
		return "adminDashboard";
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
			
			return "redirect:/adminlogin1?error";
		}
	}
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	DailyDairyRecordService dairyRecordService;
	
	@Autowired
	DailyMilkRecordService milkRecordService;
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/login")
	public String login(@ModelAttribute UserRequest userRequest,Model model,RedirectAttributes redirectAttributes) {
		
		try {
			String result = lservice.loginUser(userRequest.getUsername(),userRequest.getPassword());
			//System.out.println(result);
			UserData user = userService.getUserByAdhaar(userRequest.getUsername());
			List<DailyMilkRecord> milkRecords = milkRecordService.getMilkRecordById(user.getUser_id());
			List<PaymentHistory> paymentRecord = paymentService.getHistoryByID(user.getUser_id());
			
			System.out.println(user);
			System.out.println(milkRecords);
			System.out.println(paymentRecord);
			
			model.addAttribute("User", user);
			model.addAttribute("milkHistory", milkRecords);
			model.addAttribute("paymentHistory", paymentRecord);
			
			return "userDashboard";
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
				
				return "redirect:/loginPage?error";
			}
			}
		
		 @GetMapping("/changePass/{id}")
		    public String changePassword(@PathVariable int id,Model model,RedirectAttributes redirectAttributes) {
		     
			 model.addAttribute("userId", id);
			 
		     return "changePass";

		    }
		 
		 @PostMapping("/change-password")
		 public String changePass(@ModelAttribute ChangePassword changePassword, Model model) {
			
			 System.out.println(changePassword);
			 
			 boolean isPasswordChanged = userService.changePassword(changePassword.getOldPass(), changePassword.getNewPass(), changePassword.getuId());
               
		        if (isPasswordChanged) {
		        	
		        	userService.changePasswordById(changePassword, changePassword.getuId());
		            // Return success response
		        	return "redirect:/loginPage";
		        } else {
		            // Return failure response (old password is incorrect or user not found)
		        	return "redirect:/changePass/"+changePassword.getuId()+"?error";
		        }
		    }
			 
			 
			 //
		 }
		