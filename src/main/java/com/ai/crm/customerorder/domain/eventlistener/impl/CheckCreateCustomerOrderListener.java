package com.ai.crm.customerorder.domain.eventlistener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.event.CreateNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.CreateNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.CreateOrderRequested;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.ICheckCreateCustomerOrderListener;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.service.interfaces.ICheckCreateCustomerOrder;
@Component
public class CheckCreateCustomerOrderListener implements ICheckCreateCustomerOrderListener {
	public CheckCreateCustomerOrderListener(){
		
	}
	
	@Autowired
	private ICheckCreateCustomerOrder checkCreateCustomerOrder;

	@EventListener
	public void onCreateOrderRequestedEvent(CreateOrderRequested event) {
		checkCreateCustomerOrder.checkCreateNewOrderCustomerAvalibity((ICustomerOrder)event.getCustomerOrder());
		
	}

	@EventListener
	public void onCreateNewOfferOrderRequestedEvent(CreateNewOfferOrderRequested event) {
		checkCreateCustomerOrder.checkCreateNewOfferOrderAvalibity((IOfferOrder)event.getOfferOrder());

	}

	@EventListener
	public void onCreateNewProductOrderRequestedEvent(CreateNewProductOrderRequested event) {
		// TODO Auto-generated method stub
		checkCreateCustomerOrder.checkCreateNewProductOrderAvalibity((IProductOrder)event.getProductOrder());
	}

}