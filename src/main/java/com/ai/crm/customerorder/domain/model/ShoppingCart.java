package com.ai.crm.customerorder.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@DiscriminatorValue("1001")
@Table(name="ORD_SHOPPING_CART")
public class ShoppingCart extends CustomerOrder{

	public ShoppingCart() {
		super(10001);
	}

}
