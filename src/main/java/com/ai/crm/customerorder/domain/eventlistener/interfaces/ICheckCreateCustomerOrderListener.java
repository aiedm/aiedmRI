package com.ai.crm.customerorder.domain.eventlistener.interfaces;

import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;

public interface ICheckCreateCustomerOrderListener {
	void onCreateOrderRequestedEvent(CreateOrderRequested event) throws Exception;
	void onCreateNewOfferOrderRequestedEvent(CreateNewOfferOrderRequested event) throws Exception;
	void onCreateNewProductOrderRequestedEvent(CreateNewProductOrderRequested event) throws Exception;
}
