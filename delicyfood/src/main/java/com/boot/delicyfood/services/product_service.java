package com.boot.delicyfood.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.boot.delicyfood.repositiries.productRepo;
import com.boot.delicyfood.DTO.productDTO;
import com.boot.delicyfood.entities.*;
import com.boot.delicyfood.error.entityNotFound;
@Service
public class product_service {

	@Autowired
	private productRepo  productRepo; 
	
	
	@Cacheable(key="#root.methodName",value="products")
	public List<product> getVegetables()
	{
		Long cat_id =(long) 1;
	  return productRepo.getProducts(cat_id);
		
	}
	
	@Cacheable(key="#root.methodName",value="products")
	public List<product> getFruits()
	{
		Long cat_id =(long) 2;
	  return productRepo.getProducts(cat_id);
	  
	}

	@Cacheable(key="#id",value="pro")
	public product getproduct (Long id )
	{
		
		return  productRepo.findByProductID(id);
	}
	
	@Caching(evict= {@CacheEvict(key="#root.methodName",value="products",allEntries = true),@CacheEvict(key="#root.methodName",value="products",allEntries = true)})
	public List<product> add_ALLproducts (List<product> entity )
	{
		
		return  productRepo.saveAll(entity);
	}
	
	
	@Caching(evict= {@CacheEvict(key="#root.methodName",value="products",allEntries = true),@CacheEvict(key="#root.methodName",value="products",allEntries = true)})
	public product add_product (product entity )
	{
		
		
	if(entity.getProductID()!=null)
	{
		throw new entityNotFound("entity not found");
	}
		
		return  productRepo.save(entity);
		
	}
	
	@Caching(evict= {@CacheEvict(key="#root.methodName",value="products",allEntries = true),@CacheEvict(key="#root.methodName",value="products",allEntries = true)})
	public product update_product (product entity )
	{
		

		if(entity.getProductID() ==null)
		{
			throw new entityNotFound("entity not found");
		}
		
		product p =productRepo.findByProductID(entity.getProductID());
		
		if(p ==null)
		{
			throw new entityNotFound("entity not found");
		}
		
		p.setProductID(entity.getProductID());
		p.setName(entity.getName());
		p.setPrice(entity.getPrice());
		p.setQuantity(entity.getQuantity());
		p.setImagePath(entity.getImagePath());
		p.setCat_id(entity.getCat_id());
		
		return  productRepo.save(p);	
	}
	
	
	@Caching(evict= {@CacheEvict(key="#root.methodName",value="products",allEntries = true),@CacheEvict(key="#root.methodName",value="products",allEntries = true)})
	public void  delete_product (Long id )
	{
		
		if(id == null)
		{
			throw new entityNotFound("entity not found");
		}
		
		product p =productRepo.findByProductID(id);
		
		if(p ==null)
		{
			throw new entityNotFound("entity not found");
		}
         productRepo.deleteById(id);
	}
	
	
}
