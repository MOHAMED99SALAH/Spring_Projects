package com.boot.delicyfood.notification;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.delicyfood.entities.orders;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Notification_Controller ")
@RestController
@CrossOrigin
@RequestMapping("/delicyfood")
@Validated
public class notificationController {

	@Autowired
	notificationService notificationServise;

	@Operation(summary = "send notification to specific user")
	@RequestMapping(value = "/sendNotification", method = RequestMethod.POST)
	public ResponseEntity<?> sendNotification(@RequestBody @Valid notification notification) {
		return ResponseEntity.ok(notificationServise.sendNotificationByToken(notification));
	}

}
