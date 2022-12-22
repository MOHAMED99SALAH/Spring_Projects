package com.boot.delicyfood.repositiries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.delicyfood.entities.orders;
import com.boot.delicyfood.entities.product;



@Repository
public interface ordersRepo extends JpaRepository<orders, Long> {

	
	

	@Query(value="select o.id from orders o where o.Email = ?1")
	Long getOrderID(String Email);
	
	
	
}
