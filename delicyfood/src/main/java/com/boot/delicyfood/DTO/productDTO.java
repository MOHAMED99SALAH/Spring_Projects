package com.boot.delicyfood.DTO;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.boot.delicyfood.entities.order_details;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class productDTO {



	Long productID;

	String name;
	

	String price ;
	
	double quantity;
	
	String imagePath;
	
	Long cat_id;
	
	
}
