package com.boot.delicyfood.repositiries;
import com.boot.delicyfood.entities.driver;
import com.boot.delicyfood.entities.product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface driverRepo extends JpaRepository<driver, Long> {

	driver findByEmail(String email);

	@Query(value = "select d from driver d where d.status = false")
	List<Object> getDrivers();

	@Modifying
	@Transactional
	@Query("UPDATE driver d SET d.status = ?1 WHERE d.email = ?2")
	int updateStatus(boolean status, String driverEmail);

}
