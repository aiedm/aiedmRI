package com.ai.crm.customerorder.domain.eventlistener.interfaces;

import com.ai.crm.customerorder.domain.event.CreateNewOfferOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.CreateNewProductOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.CreateOrderCustomerAvalibityCheckPassed;
import com.ai.crm.customerorder.domain.event.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.NewProductOrderCreated;

public interface ICreateCustomerOrderListener {
	void onCreateOrderCustomerAvalibityCheckPassedEvent(CreateOrderCustomerAvalibityCheckPassed event);
	void onCreateNewOfferOrderCheckPassedEvent(CreateNewOfferOrderCheckPassed event);
	void onCreateNewProductOrderCheckPassedEvent(CreateNewProductOrderCheckPassed event);
	void onCustomerOrderCreatedEvent(CustomerOrderCreated event);
	void onCreatedOfferOrderFinishedEvent(CreateOfferOrderFinished event);
	void onCreatedCustomerOrderFinishedEvent(CreateCustomerOrderFinished event);
	void onNewProductOrderCreated(NewProductOrderCreated event);
	void onNewOfferOrderCreated(NewOfferOrderCreated event);
}
