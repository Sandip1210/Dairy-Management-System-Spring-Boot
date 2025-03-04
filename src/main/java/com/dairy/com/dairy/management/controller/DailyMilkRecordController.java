package com.dairy.com.dairy.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dairy.com.dairy.management.Request.Milkrecord;
import com.dairy.com.dairy.management.entity.DailyMilkRecord;
import com.dairy.com.dairy.management.entity.UserData;
import com.dairy.com.dairy.management.service.DailyMilkRecordService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class DailyMilkRecordController {
	
	@Autowired
	DailyMilkRecordService dms;
	
	@PostMapping("/addmilk")
	public String  addMilkById(@ModelAttribute Milkrecord dailymilk,RedirectAttributes redirectAttributes)
	{
		System.out.println(dailymilk );
		try {
	        String message= dms.addMilkById(dailymilk,dailymilk.getUserId());
           redirectAttributes.addFlashAttribute("message", message);
	        return "redirect:/addMilk?success";
		}catch(Exception e) {
			 redirectAttributes.addFlashAttribute("message", e.getMessage());
		        return "redirect:/addMilk?error";
		}
	}

	
	@GetMapping("/getallrecord")
	public String  getAllMilkRecord(Model model)
	{
		List<DailyMilkRecord> li=dms.getAllMilkRecord();
		model.addAttribute("getMilkHistory",li);
		return "dailyMilkHistory";
	}
	
	@GetMapping("/getmilk/{uid}")
	public List<DailyMilkRecord> getMilkRecordById( @PathVariable int uid)
	{
		List<DailyMilkRecord> udata=dms.getMilkRecordById(uid);
		return udata;
	}

}
