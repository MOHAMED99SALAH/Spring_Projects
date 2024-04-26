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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.delicyfood.entities.driver;
import com.boot.delicyfood.entities.orders;
import com.boot.delicyfood.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Tag(name = "Order_Controller ")
@RestController
@CrossOrigin
@RequestMapping("/delicyfood")
@Validated
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Operation(summary = "add order to database")
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<?> addOrder(@RequestBody @Valid orders order) {
		return ResponseEntity.ok(orderService.saveOrder(order));
	}

	@Operation(summary = "get last order for specific user by its Email")
	@RequestMapping(value = "/lastOrders/{Email}", method = RequestMethod.GET)
	public ResponseEntity<?> getLastOrders(
			@Parameter(example = "mohamed_123@gmail.com ", name = "Email") @PathVariable @Valid @Email String Email) {
		return ResponseEntity.ok(orderService.get_Last_orders(Email));

	}

	@Operation(summary = "get orders for specific driver by its id ")
	@RequestMapping(value = "/OrdersbyDriver/{email}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrdersbyDriver(@PathVariable @Valid String email) {
		return ResponseEntity.ok(orderService.get_orders_byDriver(email));

	}

	@Operation(summary = "update StatusOfmarket in order ")
	@RequestMapping(value = "/updateOrderStatusOfmarket/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update_statusOFmarket(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.updateStatusOFmarket(id));
	}

	@Operation(summary = "update StatusOfdriver in order  ")
	@RequestMapping(value = "/updateOrderStatusOfdriver/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update_statusOFdriver(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.updateStatusOFdriver(id));
	}

	@Operation(summary = "update driverID in order  ")
	@RequestMapping(value = "/updateDriverID/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDriverID(@PathVariable Long id, @RequestBody driver driver) {
		return ResponseEntity.ok(orderService.updateDriverID(driver, id));
	}

	@Operation(summary = "get all orders ")
	@RequestMapping(value = "/getOrders", method = RequestMethod.GET)
	public ResponseEntity<?> getOrders() {
		return ResponseEntity.ok(orderService.get_orders());

	}

	@Operation(summary = "get id for specific user by its Email")
	@RequestMapping(value = "/getID/{Email}", method = RequestMethod.GET)
	public ResponseEntity<?> getId(
			@PathVariable @Parameter(example = "mohamed_123@gmail.com ", name = "Email") @Valid @Email @NotBlank @NotNull String Email) {
		return ResponseEntity.ok(orderService.getOrderID(Email));
	}

}
