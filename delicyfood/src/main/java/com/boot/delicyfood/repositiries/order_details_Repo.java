package com.boot.delicyfood.repositiries;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.boot.delicyfood.entities.order_details;
import com.boot.delicyfood.entities.product;

@Repository
public interface Order_details_Repo extends JpaRepository<order_details, Long> {

}
