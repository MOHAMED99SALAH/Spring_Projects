package com.HRmanagement.HRmanagement.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.HRmanagement.HRmanagement.entities.department;
import com.HRmanagement.HRmanagement.services.dept_service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Validated
@Tag(name = "department_controller")
@RequiredArgsConstructor
@RestController
@RequestMapping("/depertment")
public class department_controller {

	private final dept_service deptService;

	@Operation(summary = " find department by id")
	@RequestMapping(value = "/findDepartment/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<department>> findDepartmentById(@PathVariable @NotNull Long id) {
		Optional<department> dept = deptService.findById(id);
		return ResponseEntity.ok(dept);
	}

	@Operation(summary = " get all  departments")
	@RequestMapping(value = "/getAllDepartments", method = RequestMethod.GET)
	public ResponseEntity<List<department>> findAllDepartment() {
		List<department> depts = deptService.findAll();
		return ResponseEntity.ok(depts);
	}

	@Operation(summary = " add new  department")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<department> add(@RequestBody @Valid department dept) {

		return ResponseEntity.ok(deptService.insrt(dept));

	}

	@Operation(summary = " update department ")
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.PUT)
	public ResponseEntity<department> updatee(@RequestBody @Valid department dept) {

		department deptREF = deptService.getbyid(dept.getId());

		LocalDateTime date = LocalDateTime.now();
		deptREF.setDeptName(dept.getDeptName());
		deptREF.setDate(date);

		return ResponseEntity.ok(deptService.update(deptREF));
	}

	@Operation(summary = " delete department by its id ")
	@RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDepartmentById(@PathVariable @NotNull Long id) {

		deptService.deleteById(id);
		return ResponseEntity.ok(null);
	}

}
