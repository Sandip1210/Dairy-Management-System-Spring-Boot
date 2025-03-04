package com.dairy.com.dairy.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dairy.com.dairy.management.Request.AddUser;
import com.dairy.com.dairy.management.Request.UserRequest;
import com.dairy.com.dairy.management.entity.UserData;
import com.dairy.com.dairy.management.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserService uservice;
	
	

	@GetMapping("/GetAllUser")
	public String getAllStudent(Model model)
	{
		List<UserData> li=uservice.getAllUser();
		model.addAttribute("users", li);
		return "allUsers";
	}
	
	@PostMapping("/addnewuser")
	public String addCustomer(@ModelAttribute UserData udata,Model model,RedirectAttributes redirectAttributes)
	{
		String message=uservice.addCustomer(udata);
		System.out.println(message);

        redirectAttributes.addFlashAttribute("message", message);
	        return "redirect:/addUser1?success";
		
	}
	
	@GetMapping("/getuser/{uid}")
	public UserData getUserByID( @PathVariable int uid)
	{
		UserData udata=uservice.getUserByID(uid);
		return udata;
	}


	@DeleteMapping("/users/delete")
	public ResponseEntity<Map<String, String>> deleteUserById(@RequestParam("user_id") int userId) {
	    try {
	    	uservice.deleteUserById(userId);  // Call the service layer to delete the user
	        Map<String, String> response = new HashMap<>();
	        response.put("status", "success");
	        response.put("message", "User deleted successfully.");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        Map<String, String> response = new HashMap<>();
	        response.put("status", "error");
	        response.put("message", "Error deleting user.");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	
	@PutMapping("updateuser/{id}")
	public void updateUserByID(@RequestBody UserData udata,@PathVariable int id)
	{
		uservice.updateUserById(udata, id);
	}
	
//	@GetMapping("/changePass")
//	 public String changePass() {
//		return "changePass";
//	}
	

	
	
	
	
	
	
	
	

}
