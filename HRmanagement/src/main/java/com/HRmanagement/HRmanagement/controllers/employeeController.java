package com.HRmanagement.HRmanagement.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.HRmanagement.HRmanagement.entities.Employee;
import com.HRmanagement.HRmanagement.models.passwordRequest;
import com.HRmanagement.HRmanagement.models.passwordResponse;
import com.HRmanagement.HRmanagement.services.Employee_service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Tag(name = "employee_Controller")
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/employee")
public class employeeController {

	private final PasswordEncoder passEncoder;
	private final Employee_service emp_service;

	@Operation(summary = " find employee by id ")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Employee>> findById(@PathVariable @NotNull Long id) {
		Optional<Employee> emp = emp_service.findById(id);
		return ResponseEntity.ok(emp);
	}

	@Operation(summary = " find employee by user name ")
	@RequestMapping(value = "/getUser/{username}", method = RequestMethod.GET)
	public ResponseEntity<Employee> findByusername(@PathVariable @NotNull String username) {
		Employee emp = emp_service.findByusername(username);
		return ResponseEntity.ok(emp);
	}

	@Operation(summary = " get all employees ")
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> emps = emp_service.findAll();
		return ResponseEntity.ok(emps);
	}

	@Operation(summary = " insert new employee ")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Employee> insert(@RequestBody @Valid Employee emp) {

		return ResponseEntity.ok(emp_service.insert(emp));

	}

	@Operation(summary = " update employee  ")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Employee> update(@RequestBody @Valid Employee emp) {

		return ResponseEntity.ok(emp_service.update(emp));
	}

	@Operation(summary = " delete employee by its id ")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteById(@PathVariable @NotNull Long id) {

		emp_service.deleteById(id);
		return ResponseEntity.ok(null);
	}

	@Operation(summary = " change the password of the user ")
	@RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
	public passwordResponse changePassword(@RequestBody passwordRequest request, Principal connectedUser) {
		emp_service.changepassword(request, connectedUser);
		return passwordResponse.builder().message("password changed successfully").build();
	}

}
