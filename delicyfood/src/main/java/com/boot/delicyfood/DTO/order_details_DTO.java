package com.boot.delicyfood.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

import com.boot.delicyfood.entities.orderID;
import com.boot.delicyfood.entities.orders;
import com.boot.delicyfood.entities.product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class order_details_DTO {

	
	@EmbeddedId
	 private orderID orderID =new orderID();

	private orders order;
		

	private product product;

	private Long quantity;



	
}
