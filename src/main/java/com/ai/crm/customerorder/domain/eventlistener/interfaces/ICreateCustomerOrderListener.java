package com.ai.crm.customerorder.domain.eventlistener.interfaces;

import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderCustomerAvalibityCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewProductOrderCreated;

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
