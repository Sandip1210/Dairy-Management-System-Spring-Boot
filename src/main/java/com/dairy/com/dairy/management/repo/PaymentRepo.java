package com.dairy.com.dairy.management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dairy.com.dairy.management.entity.DailyMilkRecord;
import com.dairy.com.dairy.management.entity.PaymentHistory;

public interface PaymentRepo extends JpaRepository<PaymentHistory,Integer > {
	@Query("SELECT d FROM PaymentHistory d WHERE d.user_data.user_id = :userId")
    List<PaymentHistory> findByUser_data_User_id(@Param("userId") int userId);

}
