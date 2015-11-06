package com.ai.crm.customerorder.domain.eventlistener.interfaces;

import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;

public interface ICheckCreateCustomerOrderListener {
	void onCreateOrderRequestedEvent(CreateOrderRequested event) throws Exception;
	void onCreateNewOfferOrderRequestedEvent(CheckNewOfferOrderRequested event) throws Exception;
	void onCreateNewProductOrderRequestedEvent(CheckNewProductOrderRequested event) throws Exception;
}
