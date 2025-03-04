package com.dairy.com.dairy.management.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.dairy.com.dairy.management.entity.OrderDetials;
import com.dairy.com.dairy.management.entity.Products;
import com.dairy.com.dairy.management.repo.OrderRepo;
import com.dairy.com.dairy.management.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired 
	ProductRepo prepo;
	
	@Autowired
	OrderRepo orderRepository;
	
	public String addProducts(Products p)
	{
		prepo.save(p);
		return"Sucessfully addded";
	}
	
	public List<Products> getAllProducts()
	{
		List<Products> li=prepo.findAll();
		System.out.println();
		return li;
	}
	
	
	
	
	public String placeOrder(OrderDetials od) {
		LocalDate currentDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(currentDate);
        // Step 1: Fetch product from the database
		int id=od.getProId();
        Products product = prepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        // Step 2: Check if the quantity is available
        if (product.getQty() < od.getQuantity()) {
            System.out.println("Insufficient product quantity"); 
        }

        // Step 3: Place the order (create an order entity)
        OrderDetials order = new OrderDetials();
        order.setDate(date);
        order.setUserId(od.getUserId());
        order.setAddress(od.getAddress());
        order.setQuantity(od.getQuantity());
        order.setProId(id);
        order.setProductname(product.getName());
        order.setPrice(product.getPrice());
        order.setUfullname(od.getUfullname());
        int totalprice=product.getPrice()*od.getQuantity();
        order.setTotalPrice(totalprice);
        order.setOrderStatus("false");
        
        
        orderRepository.save(order); // Save the order to the database

        // Step 4: Update the product quantity in the database
        product.setQty(product.getQty() - od.getQuantity());
        prepo.save(product); // Save the updated product

        System.out.println( "Order placed successfully!");
		return null;
    }
	
	
	public List<OrderDetials> OrderHistory()
	{
		return orderRepository.findAll();
	}
	
	
	public void accpetOrder(int oid)
	{
		OrderDetials od=orderRepository.findById(oid).get();
		od.setOrderStatus("true");
		orderRepository.save(od);
		
	}

	
	

}
