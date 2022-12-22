package com.boot.delicyfood.repositiries;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.delicyfood.DTO.productDTO;
import com.boot.delicyfood.entities.product;



@Repository
public interface productRepo extends JpaRepository<product, Long>{
	
	

	@Query(value="select p from product p where p.cat_id = ?1")
	List<product>getProducts(Long  id);
	

	
	product findByProductID(Long productId);
	
	
	
}
