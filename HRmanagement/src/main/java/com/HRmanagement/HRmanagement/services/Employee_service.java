package com.HRmanagement.HRmanagement.services;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.HRmanagement.HRmanagement.entities.Employee;
import com.HRmanagement.HRmanagement.error.RecordNotFound;
import com.HRmanagement.HRmanagement.error.passwordErrors;
import com.HRmanagement.HRmanagement.models.passwordRequest;
import com.HRmanagement.HRmanagement.repositories.emp_repository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Employee_service {

	private final emp_repository emp_repo;

	private final PasswordEncoder passEncoder;

	Logger log = LoggerFactory.getLogger(Employee_service.class);

	public Optional<Employee> findById(Long id) {

		Optional<Employee> emp = emp_repo.findById(id);

		if (emp.isPresent()) {
			return emp;

		} else {
			log.error("id is null");
			throw new RecordNotFound("Record Not Found");
		}

	}

	public Employee findByusername(String username) {

		Optional<Employee> emp = emp_repo.findByUsername(username);

		if (emp.get().getUsername() != null) {
			return emp.get();

		} else {
			throw new RecordNotFound("Record Not Found");
		}

	}

	public Employee getbyid(Long id) {
		return emp_repo.getById(id);
	}

	public List<Employee> findAll() {
		return emp_repo.findAll();

	}

	public Employee insert(Employee emp) {

		Employee empREF = emp;

		LocalDateTime date = LocalDateTime.now();
		empREF.setId(emp.getId());
		empREF.setPassword(passEncoder.encode(emp.getPassword()));
		empREF.setRole(emp.getRole());
		empREF.setFullName(emp.getFullName());
		empREF.setSalary(emp.getSalary());
		empREF.setDate(date);

		log.info("entity is inserted successfully");
		return emp_repo.save(emp);

	}

	public Employee update(Employee emp) {

		Employee empREF = getbyid(emp.getId());

		LocalDateTime date = LocalDateTime.now();
		empREF.setId(emp.getId());
		empREF.setFullName(emp.getFullName());
		empREF.setPassword(passEncoder.encode(emp.getPassword()));
		empREF.setRole(emp.getRole());
		empREF.setSalary(emp.getSalary());
		empREF.setDate(date);

		log.info("entity is updated successfully");
		return emp_repo.save(empREF);
	}

	public void deleteById(Long id) {

		Optional<Employee> emp = emp_repo.findById(id);

		if (emp.isPresent()) {
			emp_repo.deleteById(id);
		} else {
			log.info("entity is deleted successfully");
			throw new RecordNotFound("Record Not Found");
		}
	}

	public void changepassword(passwordRequest request, Principal connectedUser) {
		Employee user = (Employee) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

		if (!passEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
			throw new passwordErrors(" wrong password");
		}

		if (!request.getNewPassword().equals(request.getConfirmedPassword())) {
			throw new passwordErrors("Password doesn't matched");
		}

		user.setPassword(passEncoder.encode(request.getNewPassword()));
		emp_repo.save(user);
	}
}
