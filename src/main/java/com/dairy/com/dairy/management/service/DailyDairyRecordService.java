package com.dairy.com.dairy.management.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.com.dairy.management.entity.DailyDairyRecord;
import com.dairy.com.dairy.management.entity.DailyMilkRecord;
import com.dairy.com.dairy.management.repo.DailyDairyRecordRepo;
import com.dairy.com.dairy.management.repo.DailyMilkRecordRepo;

@Service
public class DailyDairyRecordService {

    @Autowired
    DailyDairyRecordRepo record_repo;
    
    @Autowired
    DailyMilkRecordRepo dmrr;
    
    // Method to maintain the daily dairy record
    public void maintainDairyDailyRecord(DailyDairyRecord ddr, Date date1) {
    	 LocalDate currentDate = LocalDate.now();
		    java.sql.Date date = java.sql.Date.valueOf(currentDate);
        // Get all DailyMilkRecords for the specified date
        List<DailyMilkRecord> dmr = dmrr.findByDate(date1);

        // Initialize variables to calculate totals
        int total_rs = 0, total_milk = 0, count = 0;

        // Loop through each DailyMilkRecord and calculate totals
        for (DailyMilkRecord dmr1 : dmr) {
            count++;  // Increment customer count
            total_rs += dmr1.getTotal_rs();  // Add to total money
            total_milk += dmr1.getQty();  // Add to total milk quantity
        }

        // Check if a record for the given date exists
        Optional<DailyDairyRecord> existingRecord = record_repo.getByDate(date1);

        // If record exists, update it
        if (existingRecord.isPresent()) {
            DailyDairyRecord ddr12 = existingRecord.get();
            ddr12.setTotal_cust(count);
            ddr12.setTotal_milk(total_milk);
            ddr12.setTotal_rs(total_rs);
            record_repo.save(ddr12);  // Save updated record
        } else {
            // If no record exists, create a new one and save
            DailyDairyRecord newRecord = new DailyDairyRecord();
            newRecord.setDate(date1);
            newRecord.setTotal_cust(count);
            newRecord.setTotal_milk(total_milk);
            newRecord.setTotal_rs(total_rs);
            record_repo.save(newRecord);  // Save new record
        }
    }

    // Method to get all records (no date filtering)
    public List<DailyDairyRecord> getAllRecord() {
        return record_repo.findAll();
    }

    // Method to get all records for a specific date
    public List<DailyDairyRecord> getAllRecordByDate(Date date1) {
        return record_repo.findByDate(date1);
    }
}
