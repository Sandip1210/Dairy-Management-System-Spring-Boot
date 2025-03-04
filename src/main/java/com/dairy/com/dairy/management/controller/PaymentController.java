package com.dairy.com.dairy.management.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dairy.com.dairy.management.Request.PaymentRequest;
import com.dairy.com.dairy.management.entity.PaymentHistory;
import com.dairy.com.dairy.management.service.PaymentService;

@Controller
public class PaymentController {
	@Autowired
	PaymentService ps;
	
	@PostMapping("/paymentRequest")
	public String makePayment(@ModelAttribute PaymentRequest paymentRequest, RedirectAttributes redirectAttributes)
	{
		try {
			 PaymentHistory ph = new PaymentHistory();
			 System.out.println(paymentRequest);
			
		String message=ps.makePayment(paymentRequest.getEndDate(),paymentRequest.getUserId());
		
			 
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/makePayment?success";
	}catch(Exception e) {
		redirectAttributes.addFlashAttribute("message", e.getMessage());
		return "redirect:/makePayment?error";
	}
	}
	
	@GetMapping("gethistory/{id}")
	public List<PaymentHistory> getById(@PathVariable int id)
	{
		List<PaymentHistory> ph1=ps.getHistoryByID(id);
		return ph1;
	}
	
	
	@GetMapping("/gethistory")
	public String getById(PaymentHistory ph,Model model)
	{
		
		List<PaymentHistory> ph1=ps.getHistory(ph);
		model.addAttribute("gethistory",ph1);
		return "paymentHistory";
	}
	
	@GetMapping("/makePayment/{user_id}")
	public String makePayment1(@PathVariable int user_id,Model model) {
		System.out.println(user_id);
		
		Date date = ps.getStartDate(user_id);
		
		System.out.println(date);
		model.addAttribute("userId", user_id);
		model.addAttribute("satrtDate", date);
		
		return "makePayment";
	}
	

}
