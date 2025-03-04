package com.dairy.com.dairy.management.repo;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dairy.com.dairy.management.entity.DailyDairyRecord;

public interface DailyDairyRecordRepo extends JpaRepository<DailyDairyRecord, Integer>{


    // Custom query to get DailyDairyRecord by date
    Optional<DailyDairyRecord> getByDate(Date date);
    
    // Custom query to get all DailyDairyRecord entries by date
    List<DailyDairyRecord> findByDate(Date date);
}
