package com.HRmanagement.HRmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRmanagement.HRmanagement.entities.Employee;

@Repository
public interface emp_repository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByUsername(String username);
}
