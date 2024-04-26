package com.boot.delicyfood.notification;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class notification {

	String Token;
	String title;
	String body;
	String image;

}
