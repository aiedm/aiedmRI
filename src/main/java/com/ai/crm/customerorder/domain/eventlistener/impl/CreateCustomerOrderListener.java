package com.ai.crm.customerorder.domain.eventlistener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.SubscribeOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.SubscribeOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.SubscribeProductOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.SubscribeProductOrderRequested;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateOfferOrder;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateProductOrder;
@Component
public class CreateCustomerOrderListener {
	public CreateCustomerOrderListener(){
		
	}
	@Autowired
	private ICreateCustomerOrder createCustomerOrder;
	@Autowired
	private ICreateOfferOrder createOfferOrder;
	@Autowired
	private ICreateProductOrder createProductOrder;
	
	
	@EventListener
	public void onCreateOrderCustomerAvalibityCheckPassedEvent(CheckOrderCustomerAvalibityPassed event)  throws Exception{
		createCustomerOrder.createCustomerOrder(event);
	}

	@EventListener
	public void onSubscriberOfferOrderRequestedEvent(SubscribeOfferOrderRequested event)  throws Exception{
		createOfferOrder.createSubscribeOfferOrder((OfferOrderItem)event.getOfferOrder());
	}

	@EventListener
	public void onSubscribeProductOrderRequestedEvent(SubscribeProductOrderRequested event)  throws Exception{
		createProductOrder.createSubscribeProductOrder((ProductOrderItem)event.getProductOrder());

	}

	@EventListener
	public void onCustomerOrderCreatedEvent(CustomerOrderCreated event)  throws Exception{
		createCustomerOrder.distributeOrderItemCreate((CustomerOrder)event.getCustomerOrder());

	}

	@EventListener
	public void onCreatedOfferOrderFinishedEvent(CreateOfferOrderFinished event)  throws Exception{
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastOfferOrder((OfferOrderItem)event.getOfferOrder());	
	}

	@EventListener
	public void onCreatedCustomerOrderFinishedEvent(CreateCustomerOrderFinished event)  throws Exception{
		createCustomerOrder.saveCustomerOrder(event.getCustomerOrder());

	}
	
	@EventListener
	public void onNewOfferOrderCreated(SubscribeOfferOrderCreated event)  throws Exception{
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastOfferOrder((OfferOrderItem)event.getOfferOrder());
	}	
	
	@EventListener
	public void onNewProductOrderCreated(SubscribeProductOrderCreated event)  throws Exception{
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastProductOrder((ProductOrderItem)event.getProductOrder());
	}

}
