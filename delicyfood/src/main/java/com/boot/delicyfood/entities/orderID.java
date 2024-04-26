package com.boot.delicyfood.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
public class orderID implements Serializable {

	private Long orderID;
	private Long productID;

	@Override
	public int hashCode() {
		return Objects.hash(orderID, productID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		orderID other = (orderID) obj;
		return Objects.equals(orderID, other.orderID) && Objects.equals(productID, other.productID);
	}

}
