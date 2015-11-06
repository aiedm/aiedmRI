package com.ai.crm.customerorder.domain.event.shoppingcart;

import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.application.service.api.dto.ShoppingCartDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;

public abstract class ShoppingCartBaseEvent extends BaseEvent {
	private ShoppingCartDTO cart;
	private Set<ToBeOfferInstanceDTO> toBeOfferInstances;
	public ShoppingCartDTO getCart() {
		return cart;
	}
	public void setCart(ShoppingCartDTO cart) {
		this.cart = cart;
	}
	public Set<ToBeOfferInstanceDTO> getToBeOfferInstances() {
		return toBeOfferInstances;
	}
	public void setToBeOfferInstances(Set<ToBeOfferInstanceDTO> toBeOfferInstances) {
		this.toBeOfferInstances = toBeOfferInstances;
	}
	public ShoppingCartBaseEvent(Object source) {
		super(source);
	}

}
