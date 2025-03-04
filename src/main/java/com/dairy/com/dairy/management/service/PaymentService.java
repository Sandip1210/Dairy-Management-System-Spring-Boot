package com.dairy.com.dairy.management.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dairy.com.dairy.management.entity.DailyMilkRecord;
import com.dairy.com.dairy.management.entity.PaymentHistory;
import com.dairy.com.dairy.management.entity.UserData;
import com.dairy.com.dairy.management.exception.InvalidDate;
import com.dairy.com.dairy.management.exception.InvalidPassword;
import com.dairy.com.dairy.management.repo.DailyMilkRecordRepo;
import com.dairy.com.dairy.management.repo.PaymentRepo;
import com.dairy.com.dairy.management.repo.UserRepo;

@Service
public class PaymentService {
	@Autowired
	DailyMilkRecordRepo drepo;
	@Autowired
	PaymentRepo prepo;
	@Autowired
	DailyMilkRecordService dmrs;
	@Autowired
	UserRepo urepo;
	
	LocalDate date1=LocalDate.now();
	
	
	Date startdate;
	int count=0;
	int totalpayment=0;
	public List<PaymentHistory> viewPaymentHistory(PaymentHistory ph)
	{
		List<PaymentHistory> paymenthistory=prepo.findAll();
		return paymenthistory;
		
	}
	
	
	public String makePayment(Date edate,int id)
	{
		UserData user_data = urepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		String name=user_data.getUser_name();
		Date joindate=user_data.getJoin_date();
		PaymentHistory ph = new PaymentHistory();
		List<PaymentHistory> paymenthistory=viewPaymentHistory(ph);
		startdate=joindate;
		for(PaymentHistory paymenthistory1:paymenthistory)
		{    
			
			UserData data=paymenthistory1.getUser_data();
			int id1=data.getUser_id();
			if(id1==id)
				startdate=paymenthistory1.getEnd_date();
				
			
		}
		
		
	
		List<DailyMilkRecord> dmr=dmrs.getMilkRecordById(id);
		
		if(edate.toLocalDate().isBefore(date1))
		{
          totalpayment=0;
		for(DailyMilkRecord milkrecord:dmr)
		{
			Date padate=milkrecord.getDate();
			if(padate != null && padate.toLocalDate().isAfter(startdate.toLocalDate()) && padate.toLocalDate().isBefore(edate.toLocalDate()))
			 {
				int trs=milkrecord.getTotal_rs();
			    totalpayment+=trs;
			 }
			
		}
		ph.setEnd_date(edate);
		ph.setStart_date(startdate);
		ph.setUser_data(user_data);
		ph.setTotal_payment(totalpayment);
		ph.setName(name);
	    
		prepo.save(ph);
		sendMilAddedMail( id, edate);
		 return "Payment "+ph.getTotal_payment()+"Rs. Succefully done to"+ph.getName();
		}
		else
			throw new InvalidDate();
		 
	
	}
	
	
	public Date getStartDate(int userId) {
		
		UserData user_data = urepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		
		String name=user_data.getUser_name();
		
		Date joindate=user_data.getJoin_date();
		List<PaymentHistory> paymenthistory = prepo.findAll();
		startdate=joindate;
		for(PaymentHistory paymenthistory1:paymenthistory)
		{    
			if(paymenthistory1.getUser_data().getUser_id() == userId) {
			UserData data=paymenthistory1.getUser_data();
			int id1=data.getUser_id();
			if(id1==userId)
				startdate=paymenthistory1.getEnd_date();
			}
			
		}
		return startdate;
	}
	
	
	public List<PaymentHistory> getHistoryByID(int id)
	{
		List <PaymentHistory> ph1=prepo.findByUser_data_User_id(id);
		return ph1;
		
	}
	
	public List<PaymentHistory> getHistory(PaymentHistory ph)
	{
		List <PaymentHistory> ph1=prepo.findAll();
		return ph1;
		
	}
	
	@Value("${spring.mail.username}")
	String fromMail;
	
	@Autowired
	JavaMailSender javaMailSender;
	 public void sendMilAddedMail(int id,Date edate)
	    {
		
		 UserData udata1=urepo.findById(id).get();
		String resiver=udata1.getEmail();
		String subject="Congatulations your Dairy Payment Successfully Done" ;
		String body="User_Name:"+udata1.getUser_name()+"\nFrom Date="+startdate+" To "+edate+"\nTotal Payment="+totalpayment;
	    SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
	    simpleMailMessage.setFrom(fromMail);
	    simpleMailMessage.setTo(resiver);
	    simpleMailMessage.setSubject(subject);
	    simpleMailMessage.setText(body); 
	    javaMailSender.send(simpleMailMessage);

	}

}
