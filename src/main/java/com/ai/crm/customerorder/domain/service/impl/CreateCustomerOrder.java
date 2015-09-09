package com.ai.crm.customerorder.domain.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.event.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.CreateNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.CreateNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.NewProductOrderCreated;
import com.ai.crm.customerorder.domain.event.SubmitOrderRequested;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
import com.ai.flyingshuttle.base.service.interfaces.IEventPublisher;
@Component
public class CreateCustomerOrder implements ICreateCustomerOrder {
	public CreateCustomerOrder(){
		
	}
	@Autowired
	private IEventPublisher eventPublisher;
	public void createCustomerOrder(ICustomerOrder customerOrder) {
		customerOrder.setOrderState(ICustomerOrder.CustomerOrderState.CREATED.getValue());
		CustomerOrderCreated event=new CustomerOrderCreated(this);
		event.setCustomerOrder(customerOrder);
		eventPublisher.publishEvent(event);
	}

	public void createNewOfferOrder(IOfferOrder offerOrder) {
		offerOrder.setOfferOrderState(IOfferOrder.OfferOrderState.CREATED.getValue());
		NewOfferOrderCreated event=new NewOfferOrderCreated(this);
		event.setOfferOrder(offerOrder);
		eventPublisher.publishEvent(event);
	}
	
	public void startCreateProductOrdersOfOfferOrder(IOfferOrder offerOrder){
		Set<IProductOrder> productOrders=offerOrder.getProductOrders();
		for (IProductOrder productOrder:productOrders) {
			CreateNewProductOrderRequested event=new CreateNewProductOrderRequested(this);
			event.setProductOrder(productOrder);
			eventPublisher.publishEvent(event);
		}
	}

	public void createNewProductOrder(IProductOrder productOrder) {
		productOrder.setProductOrderState(IProductOrder.ProductOrderState.CREATED.getValue());
		NewProductOrderCreated event=new NewProductOrderCreated(this);
		event.setProductOrder(productOrder);
		eventPublisher.publishEvent(event);
	}
	
	public void distributeOrderLineCreate(ICustomerOrder customerOrder){
		//OfferOrderLine
		Set<IOfferOrder> offerOrders=customerOrder.getOfferOrders();
		for (IOfferOrder offerOrder:offerOrders) {
			long biSpecId=offerOrder.getBusinessInteractionSpecificationId();
			//TODO replace with real newConnectionID
			if(biSpecId==0){
				CreateNewOfferOrderRequested event=new CreateNewOfferOrderRequested(this);
				event.setOfferOrder(offerOrder);
				eventPublisher.publishEvent(event);
			}else if (biSpecId==11){
				
			}
		}
		Set<IProductOrder> productOrders=customerOrder.getProductOrders();
		for (IProductOrder productOrder:productOrders) {
			long biSpecId=productOrder.getBusinessInteractionSpecificationId();
			//TODO replace with real newConnectionID
			if(biSpecId==0){
				CreateNewProductOrderRequested event=new CreateNewProductOrderRequested(this);
				event.setProductOrder(productOrder);
				eventPublisher.publishEvent(event);
			}else if (biSpecId==11){
				
			}
		}		
	}
	
	public boolean isCustomerOrderCreateFinishedOfLastOfferOrder(IOfferOrder offerOrder){
		boolean isCustomerOrderCreateFinished=true;
		//if this offerOrder is the Last OrderLine of Finished
		ICustomerOrder customerOrder=offerOrder.getCustomerOrder();
		Set<IOfferOrder> offerOrders=customerOrder.getOfferOrders();
		for (IOfferOrder aOfferOrder:offerOrders) {
			if(IOfferOrder.OfferOrderState.INITIATED.getValue() == aOfferOrder.getOfferOrderState()){
				isCustomerOrderCreateFinished=false;
				break;
			}
		}
		if(isCustomerOrderCreateFinished){
			Set<IProductOrder> productOrders=customerOrder.getProductOrders();
			for (IProductOrder aProductOrder:productOrders) {
				if(IProductOrder.ProductOrderState.INITIATED.getValue() == aProductOrder.getProductOrderState()){
					isCustomerOrderCreateFinished=false;
					break;
				}
			}	
		}
		if(isCustomerOrderCreateFinished){
			offerOrder.getCustomerOrder().setOrderState(ICustomerOrder.CustomerOrderState.CREATED.getValue());
			CreateCustomerOrderFinished event=new CreateCustomerOrderFinished(this);
			event.setCustomerOrder(offerOrder.getCustomerOrder());
			eventPublisher.publishEvent(event);
		}
		return isCustomerOrderCreateFinished;
	}
	
	public boolean isCustomerOrderCreateFinishedOfLastProductOrder(IProductOrder productOrder){
		boolean isCustomerOrderCreateFinished=true;
		//if this productOrder is the Last OrderLine of Finished
		ICustomerOrder customerOrder=productOrder.getCustomerOrder();
		Set<IProductOrder> productOrders=customerOrder.getProductOrders();
		for (IProductOrder aProductOrder:productOrders) {
			if(IProductOrder.ProductOrderState.INITIATED.getValue() == aProductOrder.getProductOrderState()){
				isCustomerOrderCreateFinished=false;
				break;
			}
		}
		if(isCustomerOrderCreateFinished){
			Set<IOfferOrder> offerOrders=customerOrder.getOfferOrders();
			for (IOfferOrder aOfferOrder:offerOrders) {
				if(IOfferOrder.OfferOrderState.INITIATED.getValue() == aOfferOrder.getOfferOrderState()){
					isCustomerOrderCreateFinished=false;
					break;
				}
			}
		}
		if(isCustomerOrderCreateFinished){
			productOrder.getCustomerOrder().setOrderState(ICustomerOrder.CustomerOrderState.CREATED.getValue());
			CreateCustomerOrderFinished event=new CreateCustomerOrderFinished(this);
			event.setCustomerOrder(productOrder.getCustomerOrder());
			eventPublisher.publishEvent(event);
		}
		return isCustomerOrderCreateFinished;
	}
	
	public boolean isOfferOrderCreateFinishedOfLastProductOrder(IProductOrder productOrder){
		boolean isOfferOrderCreateFinished=true;
		//if this productOrder is the Last OrderLine of Finished
		Set<IProductOrder> productOrders=productOrder.getOfferOrder().getProductOrders();
		for (IProductOrder aProductOrder:productOrders) {
			if(IProductOrder.ProductOrderState.INITIATED.getValue() == aProductOrder.getProductOrderState()){
				isOfferOrderCreateFinished=false;
				break;
			}
		}
		if(isOfferOrderCreateFinished){
			productOrder.getOfferOrder().setOfferOrderState(IOfferOrder.OfferOrderState.CREATED.getValue());
			CreateOfferOrderFinished event=new CreateOfferOrderFinished(this);
			event.setOfferOrder(productOrder.getOfferOrder());
			eventPublisher.publishEvent(event);
		}
		return isOfferOrderCreateFinished;
	}	
	
	public boolean isSubmitOrder(ICustomerOrder customerOrder){
		boolean isSubmitOrder=true;
		if (customerOrder.isDirectSubmitOrder()){
			SubmitOrderRequested event=new SubmitOrderRequested(this);
			event.setCustomerOrder(customerOrder);
			eventPublisher.publishEvent(event);
			//let submit process to save the order
		}else{
			isSubmitOrder=false;
			//Save the created order
			
			//wait other process to trigger the submit event
		}
		return isSubmitOrder;
	}
}
