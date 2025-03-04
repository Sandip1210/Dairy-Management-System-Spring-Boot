package com.dairy.com.dairy.management.repo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dairy.com.dairy.management.entity.DailyMilkRecord;

public interface DailyMilkRecordRepo extends JpaRepository<DailyMilkRecord,Integer> {

	
	  @Query("SELECT d FROM DailyMilkRecord d WHERE d.user_data.user_id = :userId")
	    List<DailyMilkRecord> findByUser_data_User_id(@Param("userId") int userId);

	  List<DailyMilkRecord> findByDate(Date date);

}

