package com.ai.crm.customerorder.domain.eventlistener.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.NewProductOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewProductOrderRequested;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.ICreateCustomerOrderListener;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.IOrderDTOTransfer;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.customerorder.domain.model.ShoppingCart;
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
	@Autowired
	private IOrderDTOTransfer orderDTOTransfer;
	
	@EventListener
	public void onCreateOrderCustomerAvalibityCheckPassedEvent(CheckOrderCustomerAvalibityPassed event)  throws Exception{
		CustomerOrderDTO customerOrderDTO=event.getCustomerOrderDTO();
		CustomerOrder customerOrder=orderDTOTransfer.transformNewDTO2Order(customerOrderDTO);
		if(event.getShoppingCartId()>0){
			createCustomerOrder.createCustomerOrder(customerOrder,event.getShoppingCartId());
		}else{
			createCustomerOrder.createCustomerOrder(customerOrder);
		}
		customerOrderDTO.setCustomerOrderId(customerOrder.getCustomerOrderId());
		customerOrderDTO.setCustomerOrderCode(customerOrder.getCustomerOrderCode());
	}

	@EventListener
	public void onNewOfferOrderRequestedEvent(NewOfferOrderRequested event)  throws Exception{
		createCustomerOrder.createNewOfferOrder((OfferOrderItem)event.getOfferOrder());
	}

	@EventListener
	public void onNewProductOrderRequestedEvent(NewProductOrderRequested event)  throws Exception{
		createCustomerOrder.createNewProductOrder((ProductOrderItem)event.getProductOrder());

	}

	@EventListener
	public void onCustomerOrderCreatedEvent(CustomerOrderCreated event)  throws Exception{
		createCustomerOrder.distributeOrderItemCreate((CustomerOrder)event.getCustomerOrder());

	}

	@EventListener
	public void onCreatedOfferOrderFinishedEvent(CreateOfferOrderFinished event)  throws Exception{
		OfferOrderItem offerOrder=(OfferOrderItem)event.getOfferOrder();
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastOfferOrder(offerOrder);	
	}

	@EventListener
	public void onCreatedCustomerOrderFinishedEvent(CreateCustomerOrderFinished event)  throws Exception{
		CustomerOrder customerOrder=(CustomerOrder)event.getCustomerOrder();
		customerOrderRepository.saveCustomerOrder(customerOrder);
		if(!(customerOrder instanceof ShoppingCart)){
			createCustomerOrder.startOrder(customerOrder);
		}

	}
	
	@EventListener
	public void onNewOfferOrderCreated(NewOfferOrderCreated event)  throws Exception{
		OfferOrderItem offerOrder=(OfferOrderItem)event.getOfferOrder();
		createCustomerOrder.isCustomerOrderCreateFinishedOfLastOfferOrder(offerOrder);
	}	
	
	@EventListener
	public void onNewProductOrderCreated(NewProductOrderCreated event)  throws Exception{
		ProductOrderItem productOrder=(ProductOrderItem)event.getProductOrder();
		if (null!=productOrder.getCustomerOrder()){
			createCustomerOrder.isCustomerOrderCreateFinishedOfLastProductOrder(productOrder);
		}
	}

}
