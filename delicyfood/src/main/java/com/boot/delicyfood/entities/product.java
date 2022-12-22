package com.boot.delicyfood.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(name="Product Entity")
@Entity
@Table(name="product")
@Getter
@Setter
@ToString
public class product implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Long productID;
	
	@Column(name="name")
	String name;
	
	@Column(name="price")
	String price ;
	
	@Column(name="quantity")
	double quantity;
	
	@Column(name="imagePath")
	String imagePath;
	

	@Column(name="cat_id")
	Long cat_id;
	


	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Collection<order_details> order_details = new ArrayList();


	
	
	
	
}
