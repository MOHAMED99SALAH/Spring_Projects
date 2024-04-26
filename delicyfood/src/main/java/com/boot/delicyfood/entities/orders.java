package com.boot.delicyfood.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Email;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderID")
@Schema(name = "Order Entity")
@Entity
@Table(name = "orders")
@EntityListeners({ AuditingEntityListener.class })
@Setter
@Getter
@ToString
public class orders implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long orderID;

	@Email
	@Column(name = "email")
	String Email;

	@Column(name = "userPhone")
	String userPhone;

	@Column(name = "totalprice")
	Long totalPrice;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "location_id")
	location location;

	@CreatedDate
	LocalDateTime date;

	@Column(name = "status_of_market")
	boolean status_of_market;

	@Column(name = "status_of_deriver")
	boolean status_of_deriver;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "deriver_id")
	driver driver;

	@Column(name = "device_token")
	String device_token;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<order_details> order_details = new ArrayList<>();

}
