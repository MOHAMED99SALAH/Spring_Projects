package com.boot.delicyfood.repositiries;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.boot.delicyfood.entities.driver;
import com.boot.delicyfood.entities.order_details;
import com.boot.delicyfood.entities.orders;
import com.boot.delicyfood.entities.product;

@Repository
public interface OrdersRepo extends JpaRepository<orders, Long> {

	@Query(value = "select o.id from orders o where o.date=(select max(o.date) from orders o  where o.Email = ?1)")
	Long getOrderID(String Email);

	@Query(value = "SELECT r FROM orders r where r.Email = ?1 ")
	List<Object> get_order(String Email);

	@Query(value = "SELECT r FROM orders r where r.driver.email = ?1  and r.status_of_deriver=true")
	List<Object> get_ordersBYdriver(String email);

	@Query("SELECT o FROM orders o WHERE o.date BETWEEN :startDate AND :endDate AND o.status_of_market=true")
	List<Object> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

	@Modifying
	@Transactional
	@Query("UPDATE orders o SET o.status_of_market = false WHERE o.orderID = ?1")
	int updateStatusOFmarket(Long orderId);

	@Modifying
	@Transactional
	@Query("UPDATE orders o SET o.status_of_deriver = false WHERE o.orderID = ?1")
	int updateStatusOFdriver(Long orderId);

	@Modifying
	@Transactional
	@Query("UPDATE orders o SET o.driver = ?1 WHERE o.orderID = ?2")
	int updateDriverID(driver driver, Long id);

	@Query("select o.device_token from orders o WHERE o.orderID = ?1")
	String getOrderToken(Long orderId);

}
