package com.boot.delicyfood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.delicyfood.entities.order_details;
import com.boot.delicyfood.repositiries.order_details_Repo;
@Service
public class order_details_service {

	@Autowired
	private order_details_Repo order_details_Repo;
	
	@Autowired
	private orderService orderService;
	
	
	public List<order_details> get_Last_orders(Long id )
	{
	return	order_details_Repo.get_Last_order(id);	
	}
	
	
	
	public List<order_details> get_User_orders( String Email)
	{
	
		Long order_ID =orderService.getOrderID(Email);
		
		return get_Last_orders(order_ID);
		
	}
	
	
}
