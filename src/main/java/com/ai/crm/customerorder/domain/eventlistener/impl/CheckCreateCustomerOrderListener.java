package com.ai.crm.customerorder.domain.eventlistener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;
import com.ai.crm.customerorder.domain.service.interfaces.ICheckCustomerOrder;
@Component
public class CheckCreateCustomerOrderListener{
	public CheckCreateCustomerOrderListener(){
		
	}
	
	@Autowired
	private ICheckCustomerOrder checkCustomerOrder;

	@EventListener
	public void onCreateOrderRequestedEvent(CreateOrderRequested event)  throws Exception{
		checkCustomerOrder.checkCreateOrderRequest(event);		
	}

	@EventListener
	public void onCreateNewOfferOrderRequestedEvent(CheckNewOfferOrderRequested event)  throws Exception{
		checkCustomerOrder.checkCreateNewOfferOrderRequest(event);
	}

	@EventListener
	public void onCreateNewProductOrderRequestedEvent(CheckNewProductOrderRequested event)  throws Exception{
		checkCustomerOrder.checkCreateNewProductOrderRequest(event);
	}

}
