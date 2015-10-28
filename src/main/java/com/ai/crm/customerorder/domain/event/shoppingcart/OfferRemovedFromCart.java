package com.ai.crm.customerorder.domain.event.shoppingcart;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IShoppingCart;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;

public class OfferRemovedFromCart extends BaseEvent {
	private IShoppingCart cart;
	private IToBeOfferInstance toBeOfferInstance;
	public IShoppingCart getCart() {
		return cart;
	}
	public void setCart(IShoppingCart cart) {
		this.cart = cart;
	}
	public IToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}
	public void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}
	public OfferRemovedFromCart(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
