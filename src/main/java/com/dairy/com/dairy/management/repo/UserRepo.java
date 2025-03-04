package com.dairy.com.dairy.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dairy.com.dairy.management.entity.UserData;


public interface UserRepo extends JpaRepository<UserData,Integer>  {
	
	@Query("SELECT u FROM UserData u WHERE u.aadhar_no = :aadhar_no")
    Optional<UserData> findByAadhar_no(@Param("aadhar_no") String aadhar_no);
}
