package com.boot.delicyfood.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(name = "Order_Details Entity")
@Entity
@Table(name = "order_details")
@Setter
@Getter
@ToString
public class order_details implements Serializable {

	@EmbeddedId
	private orderID orderID = new orderID();

	@ManyToOne()
	@MapsId("orderID")
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private orders order;

	@ManyToOne()
	@MapsId("productID")
	@JoinColumn(name = "product_id")
	private product product;

	@NotNull
	@Column(name = "quantity")
	private Long quantity;

}
