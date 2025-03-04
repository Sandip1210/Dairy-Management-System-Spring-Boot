package com.dairy.com.dairy.management.service;

import java.sql.Date;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dairy.com.dairy.management.Request.Milkrecord;
import com.dairy.com.dairy.management.entity.DailyDairyRecord;
import com.dairy.com.dairy.management.entity.DailyMilkRecord;
import com.dairy.com.dairy.management.entity.UserData;
import com.dairy.com.dairy.management.repo.DailyMilkRecordRepo;
import com.dairy.com.dairy.management.repo.UserRepo;



@Component
@Service
public class DailyMilkRecordService {
    @Autowired
    private DailyMilkRecordRepo milkrepo;
    
    @Autowired
    private UserRepo urepo;
    
    @Autowired
    DailyDairyRecordService dmrs;
    
    @Autowired
    DailyDairyRecord ddr;
    Date date1;
    @Autowired
    DailyMilkRecord milkrecord;
    
    int fat,degree,qty,total_rs=0,rate;
    Date date;
    String time;
    String formattedTime;
    
    public String addMilkById(Milkrecord dailymilk, int id) {
        // Retrieve the user data by id
    	 LocalDate currentDate = LocalDate.now();
		     date = java.sql.Date.valueOf(currentDate);
		    long timeInMillis = System.currentTimeMillis(); // Or any long value representing time
	        Instant instant = Instant.ofEpochMilli(timeInMillis);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
	                                                      .withZone(ZoneId.systemDefault());
	         formattedTime = formatter.format(instant);
	        

    	
        UserData user_data = urepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        String name=user_data.getUser_name();
        // Set the user data on the DailyMilkRecord object
        DailyMilkRecord milkRecord = new DailyMilkRecord();
        
      //  milkRecord.setUname(dailymilk.getUname());
        milkRecord.setDate(date);
        milkRecord.setDegree(dailymilk.getDegree());
        milkRecord.setFat(dailymilk.getFat());
        //milkRecord.setMilk_id(dailymilk.getMilk_id());
        milkRecord.setQty(dailymilk.getQty());
       // milkRecord.setRate(dailymilk.getRate());
       milkRecord.setTime(formattedTime);
      //  milkRecord.setTotal_rs(dailymilk.getTotal_rs());
        
        
        milkRecord.setUser_data(user_data);
        milkRecord.setUname(name);
         date=dailymilk.getDate();
          time=dailymilk.getTime();
          fat=dailymilk.getFat();
          degree=dailymilk.getDegree();
          qty=dailymilk.getQty();
        if(fat>=4&& degree>=28)
        	milkRecord.setRate(35);
		else if(fat>3.5 || degree>27)
			milkRecord.setRate(32);	
		else
			milkRecord.setRate(30);
            rate=milkRecord.getRate();
            total_rs=rate*qty;
            milkRecord.setTotal_rs(total_rs);
        date1=milkRecord.getDate();
        // Save and return the DailyMilkRecord object
        milkrepo.save(milkRecord);
       
        dmrs.maintainDairyDailyRecord(ddr, date1);
       sendMilAddedMail(milkRecord,id);
        return "Milk successfully Added";
     
        
    }
    
  

	public List<DailyMilkRecord> getAllMilkRecord()
	{
		
		List<DailyMilkRecord> li=milkrepo.findAll();
		return li;
		
	}
    
    public List<DailyMilkRecord> getMilkRecordById(int uid)
	{
    	List<DailyMilkRecord> udata1 = milkrepo.findByUser_data_User_id(uid);
    
		return udata1;
	}
    
   
    	@Value("${spring.mail.username}")
    	String fromMail;
    	
    	@Autowired
    	JavaMailSender javaMailSender;
    	 public void sendMilAddedMail(DailyMilkRecord dmr,int id)
    	    {
    		 DailyMilkRecord udata=milkrepo.findById(id).get();
    		 UserData udata1=udata.getUser_data();
    		String resiver=udata1.getEmail();
    		String subject="Congatulations succefully Milk added in Sandy Dairy!!" ;
    		String body="User_Name:"+udata1.getUser_name()+"\nDate="+date+"\nTime="+formattedTime+"\nUserId is ="+udata1.getUser_id()+"\nTotal milk="+udata.getQty()+" Liter\nFat="+fat+"\nDegree="+degree+"\nRate="+rate+"\nTotal Rs="+total_rs;
    	    SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
    	    simpleMailMessage.setFrom(fromMail);
    	    simpleMailMessage.setTo(resiver);
    	    simpleMailMessage.setSubject(subject);
    	    simpleMailMessage.setText(body); 
    	    javaMailSender.send(simpleMailMessage);

    	}
    }

