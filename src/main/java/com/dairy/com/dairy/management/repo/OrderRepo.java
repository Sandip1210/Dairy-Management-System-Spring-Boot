package com.dairy.com.dairy.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dairy.com.dairy.management.entity.OrderDetials;

public interface OrderRepo extends JpaRepository<OrderDetials,Integer>  {

}
