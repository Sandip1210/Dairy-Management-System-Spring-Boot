package com.dairy.com.dairy.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.com.dairy.management.entity.UserData;
import com.dairy.com.dairy.management.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService uservice;
	@GetMapping("/")
	public String homePage() {
		return "home";
	}

	@GetMapping("/loginPage")
	public String loginPage() {
		return "home";
	}
	
	@GetMapping("/mainPage")
	public String mainPage() {
		return "mainPage";
	}
	
	@GetMapping("/adminPage")
	public String adminPage() {
		return "adminDashboard";
	}
	
	@GetMapping("/addUser1")
	public String addUser() {
		return "addUser";
	}
	
	@GetMapping("/addMilk")
	public String addMilk() {
		return "addMilk";
	}
	
	
	@GetMapping("/makePayment")
	public String makePayment() {
		return "makePayment";
	}
	
	@GetMapping("/paymentAllUser1")
	public String makePaymentAll(Model model) {

		List<UserData> li=uservice.getAllUser();
		model.addAttribute("users", li);
		return "paymentAllUser";
	}
	
	@GetMapping("/adminlogin1")
	public String adminLogin() {
		return "adminLogin";
	}
	
	@GetMapping("/product")
	public String viewProductPage() {
		return "products";
	}
	
	@GetMapping("/viewproducts")
	public String viewAllProductPage() {
		return "viewproduct";
	}
	@GetMapping("/addOneProduct")
	public String addProduct() {
		return "addProducts";
	}

//	@GetMapping("/makePayment/{user_id}")
//	public String makePayment1(@PathVariable int user_id,Model model) {
//		System.out.println(user_id);
//		
//		
//		return "makePayment";
//	}
	
//	@GetMapping("/PaymentHistory1")
//	public String paymentHistory(Model model) {
//		model.add
//		return "paymentHistory";
//	}
}
