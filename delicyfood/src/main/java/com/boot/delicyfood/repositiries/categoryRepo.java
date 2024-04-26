package com.boot.delicyfood.repositiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.boot.delicyfood.entities.category;

@Repository
public interface CategoryRepo extends JpaRepository<category, Long> {

}
