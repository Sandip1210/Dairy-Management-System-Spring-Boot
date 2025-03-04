package com.dairy.com.dairy.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dairy.com.dairy.management.entity.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {
	

}
