package com.boot.delicyfood.repositiries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.delicyfood.entities.order_details;
import com.boot.delicyfood.entities.product;



@Repository
public interface order_details_Repo extends JpaRepository<order_details, Long> {

	

	

	@Query(value="select o from order_details o where o.order.orderID = ?1")
	List<order_details> get_Last_order(Long id);
	
	
}
