package com.boot.delicyfood.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.delicyfood.entities.orders;
import com.boot.delicyfood.services.orderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Tag(name="Order_Controller ")
@RestController
@CrossOrigin
@RequestMapping("/delicyfood")
@Validated
public class orderController {

	
	@Autowired
	private orderService orderService;
	@Operation(summary="add order to database")
	@RequestMapping(value="/addOrder",method =RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody @Valid orders order)
	{
		return ResponseEntity.ok(orderService.saveOrder(order));
	}
	
	@Operation(summary="get id for specific user by its Email")
	@RequestMapping(value="/getID/{Email}",method =RequestMethod.GET)
	public ResponseEntity<?> add(@PathVariable @Parameter(example="mohamed_123@gmail.com ",name="Email") @Valid @Email @NotBlank @NotNull String Email)
	{
		return ResponseEntity.ok(orderService.getOrderID(Email));
	}
	
}
