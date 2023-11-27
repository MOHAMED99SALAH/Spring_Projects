package com.HRmanagement.HRmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRmanagement.HRmanagement.entities.Employees;

@Repository
public interface emp_repository extends JpaRepository<Employees, Long> {

	Optional<Employees> findByUsername(String username);
}
