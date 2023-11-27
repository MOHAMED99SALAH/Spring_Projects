package com.HRmanagement.HRmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRmanagement.HRmanagement.entities.department;



@Repository
public interface dept_Repo extends JpaRepository<department, Long> {

	
}
