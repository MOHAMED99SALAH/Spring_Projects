package com.boot.delicyfood.repositiries;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.boot.delicyfood.entities.product;

@Repository
public interface ProductRepo extends JpaRepository<product, Long> {

	@Query(value = "select p from product p where p.cat_id = ?1")
	List<product> getProducts(Long id);

	product findByProductID(Long productId);

}
