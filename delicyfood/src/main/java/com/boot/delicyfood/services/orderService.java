package com.boot.delicyfood.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.boot.delicyfood.entities.driver;
import com.boot.delicyfood.entities.order_details;
import com.boot.delicyfood.entities.orders;
import com.boot.delicyfood.entities.product;
import com.boot.delicyfood.error.RecordNotFound;
import com.boot.delicyfood.notification.notification;
import com.boot.delicyfood.notification.notificationService;
import com.boot.delicyfood.repositiries.OrdersRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderService {

	@Autowired
	private OrdersRepo ordersRepo;

	@Autowired
	private Product_service product_service;

	@Autowired
	private notificationService notification_Service;

	public orders saveOrder(orders order) {

		orders newOrder = new orders();
		newOrder.setEmail(order.getEmail());
		newOrder.setUserPhone(order.getUserPhone());
		newOrder.setTotalPrice(order.getTotalPrice());
		newOrder.setLocation(order.getLocation());
		newOrder.setDevice_token(order.getDevice_token());
		newOrder.setStatus_of_market(true);
		newOrder.setStatus_of_deriver(true);
		newOrder.setDriver(order.getDriver());
		newOrder.getOrder_details().addAll((order.getOrder_details().stream().map(order_details -> {
			product product = product_service.getproductById(order_details.getProduct().getProductID());
			order_details newOrder_detail = new order_details();
			newOrder_detail.setProduct(product);
			newOrder_detail.setOrder(newOrder);
			newOrder_detail.setQuantity(order_details.getQuantity());

			return newOrder_detail;
		}).collect(Collectors.toList())));

		orders savedorder = ordersRepo.save(newOrder);
		log.info("order saved successfully");
		return savedorder;
	}

	public Long getOrderID(String Email) {
		Long id = ordersRepo.getOrderID(Email);

		log.info("the id for Email {} = {}", Email, id);

		if (id == null) {
			throw new RecordNotFound("Email is not found");
		}
		return id;

	}

	public int updateStatusOFmarket(Long orderId) {

		sendNotification(orderId);

		return ordersRepo.updateStatusOFmarket(orderId);
	}

	public int updateStatusOFdriver(Long orderId) {

		return ordersRepo.updateStatusOFdriver(orderId);
	}

	public int updateDriverID(driver driver, Long orderId) {

		return ordersRepo.updateDriverID(driver, orderId);
	}

	void sendNotification(Long id) {

		String Token = getOrderToken(id);
		notification notify = new notification();

		notify.setTitle("DelicyFood");
		notify.setBody("The order has been completed and on its way to you ");
		notify.setToken(Token);
		notify.setImage("https://ibb.co/6W9BS1g");

		notification_Service.sendNotificationByToken(notify);
	}

	public List<Object> get_Last_orders(String Email) {
		return ordersRepo.get_order(Email);
	}

	public List<Object> get_orders_byDriver(String email) {
		return ordersRepo.get_ordersBYdriver(email);
	}

	public String getOrderToken(Long orderID) {
		return ordersRepo.getOrderToken(orderID);
	}

	public List<Object> get_orders() {
		LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
		LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

		return ordersRepo.findByDateBetween(startOfDay, endOfDay);
	}

}
