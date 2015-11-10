package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.crm.customerorder.domain.model.ShoppingCart;

public abstract class OrderSubmitCartBaseEvent extends OrderSubmitBaseEvent {
	private ShoppingCart cart;
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public OrderSubmitCartBaseEvent(Object source) {
		super(source);
	}

}
