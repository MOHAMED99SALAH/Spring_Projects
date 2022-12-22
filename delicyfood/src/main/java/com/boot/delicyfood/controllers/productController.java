package com.boot.delicyfood.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.delicyfood.services.product_service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.boot.delicyfood.DTO.productDTO;
import com.boot.delicyfood.entities.*;

@Validated
@Tag(name="Product_Controller ")
@RestController()
@RequestMapping("/delicyfood")
public class productController {

	
	@Autowired
   private product_service pro_service;
	
	@Operation(summary="get Vegetables ")
	@RequestMapping(value = "/getVegetables",method = RequestMethod.GET)
	public List<product> getvege()
	{
		return pro_service.getVegetables();	
	}
	
	
	@Operation(summary="get Fruits")
	@RequestMapping(value = "/getFruits",method = RequestMethod.GET)
	public List<product> getFruits()
	{
		return pro_service.getFruits();	
	}
	
	
	@Operation(summary="get specific product by its id")
	@RequestMapping(value = "/getproduct/{id}",method = RequestMethod.GET)
	public product getProduct(@PathVariable Long id)
	{
		return pro_service.getproduct(id);	
	}
	
	
	@Operation(summary="add many products to database")
	@RequestMapping(value = "/add_many_Product",method = RequestMethod.POST)
	public List<product> add_AllProducts(@RequestBody @Valid List<product> entity)
	{
		return pro_service.add_ALLproducts(entity);	
	}
	
	
	
	
	@Operation(summary="add  product to database")
	@RequestMapping(value = "/addProduct",method = RequestMethod.POST)
	public product add_Product(@RequestBody @Valid product entity)
	{
		return pro_service.add_product(entity);	
	}
	
	
	@Operation(summary="update  product in database")
	@RequestMapping(value = "/updateProduct",method = RequestMethod.PUT)
	public product update_Product(@RequestBody @Valid product entity)
	{
		return pro_service.update_product(entity);	
	}
	
	
	@Operation(summary="delete  product from database")
	@RequestMapping(value = "/deleteProduct/{id}",method = RequestMethod.DELETE)
	public void delete_Product(@PathVariable Long id)
	{
	   pro_service.delete_product(id);	
	}
	
	
}
