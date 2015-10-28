package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.crm.customerorder.domain.model.interfaces.IShoppingCart;

public abstract class OrderSubmitCartBaseEvent extends OrderSubmitBaseEvent {
	private IShoppingCart cart;
	public IShoppingCart getCart() {
		return cart;
	}
	public void setCart(IShoppingCart cart) {
		this.cart = cart;
	}
	public OrderSubmitCartBaseEvent(Object source) {
		super(source);
	}

}
