package com.boot.delicyfood.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.delicyfood.entities.driver;
import com.boot.delicyfood.entities.product;
import com.boot.delicyfood.services.driverService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Validated
@Tag(name = "Driver_Controller ")
@RestController()
@RequestMapping("/delicyfood")
public class driverController {

	@Autowired
	driverService drives_service;

	@Operation(summary = "add  driver to database")
	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	public ResponseEntity<?> add_driver(@RequestBody @Valid driver entity) {
		return ResponseEntity.ok(drives_service.add_driver(entity));
	}

	@Operation(summary = "get  driver from database")
	@RequestMapping(value = "/getDriver/{email}", method = RequestMethod.GET)
	public ResponseEntity<?> get_driver(@PathVariable String email) {
		return ResponseEntity.ok(drives_service.get_driver(email));
	}

	@Operation(summary = "find driver in database")
	@RequestMapping(value = "/checkDriver/{email}", method = RequestMethod.GET)
	public ResponseEntity<?> check_driver(@PathVariable String email) {
		return ResponseEntity.ok(drives_service.check_driver(email));
	}

	@Operation(summary = "get  drivers from database")
	@RequestMapping(value = "/getDrivers", method = RequestMethod.GET)
	public ResponseEntity<?> get_drivers() {
		return ResponseEntity.ok(drives_service.get_drivers());
	}

	@Operation(summary = "update  driver  status in database")
	@RequestMapping(value = "/updateDriverStatus/{email}/{status}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDriverStatus(@PathVariable String email, @PathVariable boolean status) {
		return ResponseEntity.ok(drives_service.updateStatus(status, email));
	}

}
