package com.boot.delicyfood.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.boot.delicyfood.notification.*;

@Service
public class notificationService {

	@Autowired
	FirebaseMessaging firebaseMessage;

	public String sendNotificationByToken(notification notify) {

		Notification notification = Notification.builder().setTitle(notify.title).setBody(notify.body)
				.setImage(notify.image).build();

		Message message = Message.builder().setToken(notify.Token).setNotification(notification).build();

		try {

			firebaseMessage.send(message);
			return " success message  ";

		} catch (FirebaseMessagingException e) {

			e.printStackTrace();
			return "Error sending Notification ";
		}

	}

}
