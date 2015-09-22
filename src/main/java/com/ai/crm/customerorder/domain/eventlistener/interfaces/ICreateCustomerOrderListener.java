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
	void onCreateOrderCustomerAvalibityCheckPassedEvent(CreateOrderCustomerAvalibityCheckPassed event)  throws Exception;
	void onCreateNewOfferOrderCheckPassedEvent(CreateNewOfferOrderCheckPassed event) throws Exception;
	void onCreateNewProductOrderCheckPassedEvent(CreateNewProductOrderCheckPassed event) throws Exception;
	void onCustomerOrderCreatedEvent(CustomerOrderCreated event) throws Exception;
	void onCreatedOfferOrderFinishedEvent(CreateOfferOrderFinished event) throws Exception;
	void onCreatedCustomerOrderFinishedEvent(CreateCustomerOrderFinished event) throws Exception;
	void onNewProductOrderCreated(NewProductOrderCreated event) throws Exception;
	void onNewOfferOrderCreated(NewOfferOrderCreated event) throws Exception;
}
