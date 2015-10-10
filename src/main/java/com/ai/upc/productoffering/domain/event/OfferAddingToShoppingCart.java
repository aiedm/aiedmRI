package com.ai.upc.productoffering.domain.event;

import com.ai.common.rootentity.domain.model.interfaces.BaseEvent;

public class OfferAddingToShoppingCart extends BaseEvent{

	public OfferAddingToShoppingCart(Object source) {
		super(source);
	}

}
