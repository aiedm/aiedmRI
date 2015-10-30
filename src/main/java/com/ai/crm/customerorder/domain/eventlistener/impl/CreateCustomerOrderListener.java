package com.ai.crm.customerorder.domain.eventlistener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderCustomerAvalibityCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewProductOrderCreated;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.ICreateCustomerOrderListener;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IShoppingCart;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
import com.ai.crm.customerorder.repository.interfaces.ICustomerOrderRepository;
@Component
public class CreateCustomerOrderListener implements ICreateCustomerOrderListener {
	public CreateCustomerOrderListener(){
		
	}
	@Autowired
	private ICreateCustomerOrder createCustomerOrder;
	@Autowired
	private ICustomerOrderRepository customerOrderRepository;
	
	@EventListener
	public void onCreateOrderCustomerAvalibityCheckPassedEvent(CreateOrderCustomerAvalibityCheckPassed event)  throws Exception{
		if(event.getShoppingCartId()>0){
			createCustomerOrder.createCustomerOrder((ICustomerOrder)event.getCustomerOrder(),event.getShoppingCartId());
		}else{
			createCustomerOrder.createCustomerOrder((ICustomerOrder)event.getCustomerOrder());
		}		
	}

	@EventListener
	public void onCreateNewOfferOrderCheckPassedEvent(CreateNewOfferOrderCheckPassed event)  throws Exception{
		createCustomerOrder.createNewOfferOrder((IOfferOrderItem)event.getOfferOrder());
	}

	@EventListener
	public void onCreateNewProductOrderCheckPassedEvent(CreateNewProductOrderCheckPassed event)  throws Exception{
		createCustomerOrder.createNewProductOrder((IProductOrderItem)event.getProductOrder());

	}

	@EventListener
	public void onCustomerOrderCreatedEvent(CustomerOrderCreated event)  throws Exception{
		createCustomerOrder.distributeOrderLineCreate((ICustomerOrder)event.getCustomerOrder());

	}

	@EventListener
	public void onCreatedOfferOrderFinishedEvent(CreateOfferOrderFinished event)  throws Exception{
		IOfferOrderItem offerOrder=(IOfferOrderItem)event.getOfferOrder();
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastOfferOrder(offerOrder);	
	}

	@EventListener
	public void onCreatedCustomerOrderFinishedEvent(CreateCustomerOrderFinished event)  throws Exception{
		ICustomerOrder customerOrder=(ICustomerOrder)event.getCustomerOrder();
		customerOrderRepository.saveCustomerOrder(customerOrder);
		if(!(customerOrder instanceof IShoppingCart)){
			createCustomerOrder.startOrder(customerOrder);
		}

	}
	
	@EventListener
	public void onNewOfferOrderCreated(NewOfferOrderCreated event)  throws Exception{
		IOfferOrderItem offerOrder=(IOfferOrderItem)event.getOfferOrder();
		createCustomerOrder.startCreateProductOrdersOfOfferOrder(offerOrder);
	}	
	
	@EventListener
	public void onNewProductOrderCreated(NewProductOrderCreated event)  throws Exception{
		IProductOrderItem productOrder=(IProductOrderItem)event.getProductOrder();
		if (null!=productOrder.getOfferOrder()){
			createCustomerOrder.isOfferOrderCreateFinishedOfLastProductOrder(productOrder);
		}else if (null!=productOrder.getCustomerOrder()){
			createCustomerOrder.isCustomerOrderCreateFinishedOfLastProductOrder(productOrder);
		}
	}

}
