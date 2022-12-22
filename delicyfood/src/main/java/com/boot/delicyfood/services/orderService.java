package com.boot.delicyfood.services;

import java.util.Optional;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.boot.delicyfood.entities.order_details;
import com.boot.delicyfood.entities.orders;
import com.boot.delicyfood.entities.product;
import com.boot.delicyfood.error.RecordNotFound;
import com.boot.delicyfood.repositiries.ordersRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class orderService {

	
	
	
	@Autowired
	private ordersRepo ordersRepo;
	
	@Autowired
	private product_service product_service;
	
	
    public orders saveOrder(orders order) {
		  orders newOrder = new orders();
	        newOrder.setEmail(order.getEmail());
	        newOrder.getOrder_details().addAll((order.getOrder_details()
	                .stream()
	                .map(order_details-> {
	                	product product = product_service.getproduct(order_details.getProduct().getProductID());
	                	order_details newOrder_detail = new order_details();
	         
	                	newOrder_detail.setProduct(product);
	                	newOrder_detail.setOrder(newOrder);
	                	newOrder_detail.setQuantity(order_details.getQuantity());
	                   
	                    return newOrder_detail;
	                })
	                .collect(Collectors.toList())
	        ));
	        
	        orders savedorder =ordersRepo.save(newOrder);
	        log.info("order saved successfully");
	        return savedorder;
	    }
    
    
    public Long getOrderID(String Email)
    {
    	Long id =  ordersRepo.getOrderID(Email);
    	 
    	log.info("the id for Email {} = {}",Email,id);
    	
    	
    	if(id==null)
    	{
    		throw new RecordNotFound("Email is not found");
    	}
    	return id ;
    	
    	  
    }
    
	
}
