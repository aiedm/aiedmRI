package com.ai.crm.customerorder.domain.eventlistener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.NewProductOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewProductOrderRequested;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
@Component
public class CreateCustomerOrderListener {
	public CreateCustomerOrderListener(){
		
	}
	//@Autowired
	private ICreateCustomerOrder createCustomerOrder;
	
	
	
	//@EventListener
	public void onCreateOrderCustomerAvalibityCheckPassedEvent(CheckOrderCustomerAvalibityPassed event)  throws Exception{
		createCustomerOrder.createCustomerOrder(event);
	}

	//@EventListener
	public void onNewOfferOrderRequestedEvent(NewOfferOrderRequested event)  throws Exception{
		createCustomerOrder.createNewOfferOrder((OfferOrderItem)event.getOfferOrder());
	}

	//@EventListener
	public void onNewProductOrderRequestedEvent(NewProductOrderRequested event)  throws Exception{
		createCustomerOrder.createNewProductOrder((ProductOrderItem)event.getProductOrder());

	}

	//@EventListener
	public void onCustomerOrderCreatedEvent(CustomerOrderCreated event)  throws Exception{
		createCustomerOrder.distributeOrderItemCreate((CustomerOrder)event.getCustomerOrder());

	}

	//@EventListener
	public void onCreatedOfferOrderFinishedEvent(CreateOfferOrderFinished event)  throws Exception{
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastOfferOrder((OfferOrderItem)event.getOfferOrder());	
	}

	//@EventListener
	public void onCreatedCustomerOrderFinishedEvent(CreateCustomerOrderFinished event)  throws Exception{
		createCustomerOrder.saveCustomerOrder(event.getCustomerOrder());

	}
	
	//@EventListener
	public void onNewOfferOrderCreated(NewOfferOrderCreated event)  throws Exception{
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastOfferOrder((OfferOrderItem)event.getOfferOrder());
	}	
	
	//@EventListener
	public void onNewProductOrderCreated(NewProductOrderCreated event)  throws Exception{
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastProductOrder((ProductOrderItem)event.getProductOrder());
	}

}
