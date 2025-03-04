package com.dairy.com.dairy.management.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.com.dairy.management.entity.DailyDairyRecord;
import com.dairy.com.dairy.management.service.DailyDairyRecordService;
import com.dairy.com.dairy.management.service.DailyMilkRecordService;

@Controller
public class DailyDairyRecordController {
	
	@Autowired
	DailyDairyRecordService dds;
	@GetMapping("getDailyRecord/{date}")
	
	public List<DailyDairyRecord> getData(DailyDairyRecord ddr,@PathVariable Date date)
	{
		
		List<DailyDairyRecord> ddr1=dds.getAllRecordByDate(date);
		return ddr1;
	}
	
	@GetMapping("gelAllRecords")
	public String getAllRecords(Model model)
	{
		List<DailyDairyRecord> dr=dds.getAllRecord();
		model.addAttribute("getDairyRecords", dr);
		return "dailyDairyData";
	}

}
