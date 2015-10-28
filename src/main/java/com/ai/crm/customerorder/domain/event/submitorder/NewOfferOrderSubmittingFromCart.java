package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.crm.customerorder.domain.model.interfaces.IShoppingCart;

public class NewOfferOrderSubmittingFromCart extends NewOfferOrderDirectSubmitting {
	private IShoppingCart cart;
	public IShoppingCart getCart() {
		return cart;
	}
	public void setCart(IShoppingCart cart) {
		this.cart = cart;
	}
	public NewOfferOrderSubmittingFromCart(Object source) {
		super(source);
	}

}
