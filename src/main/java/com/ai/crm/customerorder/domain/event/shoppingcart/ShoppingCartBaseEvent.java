package com.ai.crm.customerorder.domain.event.shoppingcart;

import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IShoppingCart;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;

public abstract class ShoppingCartBaseEvent extends BaseEvent {
	private IShoppingCart cart;
	private Set<IToBeOfferInstance> toBeOfferInstances;
	public IShoppingCart getCart() {
		return cart;
	}
	public void setCart(IShoppingCart cart) {
		this.cart = cart;
	}
	public Set<IToBeOfferInstance> getToBeOfferInstances() {
		return toBeOfferInstances;
	}
	public void setToBeOfferInstances(Set<IToBeOfferInstance> toBeOfferInstances) {
		this.toBeOfferInstances = toBeOfferInstances;
	}
	public ShoppingCartBaseEvent(Object source) {
		super(source);
	}

}
