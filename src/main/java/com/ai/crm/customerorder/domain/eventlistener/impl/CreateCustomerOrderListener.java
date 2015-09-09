package com.ai.crm.customerorder.domain.eventlistener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.event.CreateNewOfferOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.CreateNewProductOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.CreateOrderCustomerAvalibityCheckPassed;
import com.ai.crm.customerorder.domain.event.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.NewProductOrderCreated;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.ICreateCustomerOrderListener;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
@Component
public class CreateCustomerOrderListener implements ICreateCustomerOrderListener {
	public CreateCustomerOrderListener(){
		
	}
	@Autowired
	private ICreateCustomerOrder createCustomerOrder;
	@EventListener
	public void onCreateOrderCustomerAvalibityCheckPassedEvent(CreateOrderCustomerAvalibityCheckPassed event) {
		createCustomerOrder.createCustomerOrder((ICustomerOrder)event.getCustomerOrder());
		
	}

	@EventListener
	public void onCreateNewOfferOrderCheckPassedEvent(CreateNewOfferOrderCheckPassed event) {
		createCustomerOrder.createNewOfferOrder((IOfferOrder)event.getOfferOrder());
	}

	@EventListener
	public void onCreateNewProductOrderCheckPassedEvent(CreateNewProductOrderCheckPassed event) {
		createCustomerOrder.createNewProductOrder((IProductOrder)event.getProductOrder());

	}

	@EventListener
	public void onCustomerOrderCreatedEvent(CustomerOrderCreated event) {
		createCustomerOrder.distributeOrderLineCreate((ICustomerOrder)event.getCustomerOrder());

	}

	@EventListener
	public void onCreatedOfferOrderFinishedEvent(CreateOfferOrderFinished event) {
		IOfferOrder offerOrder=(IOfferOrder)event.getOfferOrder();
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastOfferOrder(offerOrder);	
	}

	@EventListener
	public void onCreatedCustomerOrderFinishedEvent(CreateCustomerOrderFinished event) {
		ICustomerOrder customerOrder=(ICustomerOrder)event.getCustomerOrder();
		createCustomerOrder.isSubmitOrder(customerOrder);

	}
	
	@EventListener
	public void onNewOfferOrderCreated(NewOfferOrderCreated event){
		IOfferOrder offerOrder=(IOfferOrder)event.getOfferOrder();
		createCustomerOrder.startCreateProductOrdersOfOfferOrder(offerOrder);
	}	
	
	@EventListener
	public void onNewProductOrderCreated(NewProductOrderCreated event){
		IProductOrder productOrder=(IProductOrder)event.getProductOrder();
		if (null!=productOrder.getOfferOrder()){
			createCustomerOrder.isOfferOrderCreateFinishedOfLastProductOrder(productOrder);
		}else{
			createCustomerOrder.isCustomerOrderCreateFinishedOfLastProductOrder(productOrder);
		}
	}

}
