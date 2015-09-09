package com.ai.crm.customerorder.domain.eventlistener.interfaces;

import com.ai.crm.customerorder.domain.event.CreateNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.CreateNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.CreateOrderRequested;

public interface ICheckCreateCustomerOrderListener {
	void onCreateOrderRequestedEvent(CreateOrderRequested event);
	void onCreateNewOfferOrderRequestedEvent(CreateNewOfferOrderRequested event);
	void onCreateNewProductOrderRequestedEvent(CreateNewProductOrderRequested event);
}
