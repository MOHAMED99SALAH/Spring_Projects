package com.boot.delicyfood.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.boot.delicyfood.services.order_details_service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.boot.delicyfood.entities.*;
import javax.validation.constraints.Email;

@Tag(name="Order_Details_Controller ")
@RestController
@RequestMapping("/delicyfood")
@Validated
public class order_details_controllers {

	
	@Autowired
	private order_details_service order_details_service;
	@Operation(summary="get last orders for specific user")
	@RequestMapping(value="/lastOrders/{Email}",method =RequestMethod.GET)
	public List<order_details> getLastOrders (  @Parameter(example="mohamed_123@gmail.com ",name="Email") @PathVariable @Valid @Email String Email )
	{		
		return order_details_service.get_User_orders(Email);

	}
	
	
	
}
