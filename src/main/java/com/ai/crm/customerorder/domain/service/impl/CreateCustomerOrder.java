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
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
import com.ai.flyingshuttle.base.service.interfaces.IEventPublisher;
@Component
public class CreateCustomerOrder implements ICreateCustomerOrder {
	public CreateCustomerOrder(){
		
	}
	@Autowired
	private IEventPublisher eventPublisher;
	
	
	public void createCustomerOrder(ICustomerOrder customerOrder)  throws Exception{
		customerOrder.setOrderState(ICustomerOrder.CustomerOrderState.CREATED.getValue());
		CustomerOrderCreated event=new CustomerOrderCreated(this);
		event.setCustomerOrder(customerOrder);
		eventPublisher.publishEvent(event);
	}

	public void createNewOfferOrder(IOfferOrderItem offerOrder)  throws Exception{
		offerOrder.setOfferOrderState(IOfferOrderItem.OfferOrderState.CREATED.getValue());
		NewOfferOrderCreated event=new NewOfferOrderCreated(this);
		event.setOfferOrder(offerOrder);
		eventPublisher.publishEvent(event);
	}
	
	public void startCreateProductOrdersOfOfferOrder(IOfferOrderItem offerOrder)  throws Exception{
		Set<IProductOrderItem> productOrders=offerOrder.getProductOrders();
		if (productOrders.size()==0){
			CreateOfferOrderFinished event=new CreateOfferOrderFinished(this);
			event.setOfferOrder(offerOrder);
			eventPublisher.publishEvent(event);
		}
		for (IProductOrderItem productOrder:productOrders) {
			if(null==productOrder.getOfferOrder()){
				productOrder.setOfferOrder(offerOrder);
			}
			CreateNewProductOrderRequested event=new CreateNewProductOrderRequested(this);
			event.setProductOrder(productOrder);
			eventPublisher.publishEvent(event);
		}
	}

	public void createNewProductOrder(IProductOrderItem productOrder)  throws Exception{
		productOrder.setProductOrderState(IProductOrderItem.ProductOrderState.CREATED.getValue());
		//deal with subscriber
		
		NewProductOrderCreated event=new NewProductOrderCreated(this);
		event.setProductOrder(productOrder);
		eventPublisher.publishEvent(event);
	}
	
	public void distributeOrderLineCreate(ICustomerOrder customerOrder)  throws Exception{
		//OfferOrderLine
		Set<IOfferOrderItem> offerOrders=customerOrder.getOfferOrders();
		for (IOfferOrderItem offerOrder:offerOrders) {
			if(null==offerOrder.getCustomerOrder()){
				offerOrder.setCustomerOrder(customerOrder);
			}
			long biiSpecId=offerOrder.getBusinessInteractionItemSpecId();
			//TODO replace with real newConnectionID
			if(biiSpecId==1001){
				CreateNewOfferOrderRequested event=new CreateNewOfferOrderRequested(this);
				event.setOfferOrder(offerOrder);
				eventPublisher.publishEvent(event);
			}else if (biiSpecId==1002){
				//unsubscriber
			}else if (biiSpecId==1003){
				//modify 
			}else if (biiSpecId==1004){
				//replace 
			}
		}
		Set<IProductOrderItem> productOrders=customerOrder.getProductOrders();
		for (IProductOrderItem productOrder:productOrders) {
			if(null==productOrder.getCustomerOrder()){
				productOrder.setCustomerOrder(customerOrder);
			}
			long biiSpecId=productOrder.getBusinessInteractionItemSpecId();
			//TODO replace with real newConnectionID
			if(biiSpecId==2001){
				CreateNewProductOrderRequested event=new CreateNewProductOrderRequested(this);
				event.setProductOrder(productOrder);
				eventPublisher.publishEvent(event);
			}else if (biiSpecId==2002){
				//unsubscriber
			}else if (biiSpecId==2003){
				//modify
			}
		}		
	}
	
	public boolean isCustomerOrderCreateFinishedOfLastOfferOrder(IOfferOrderItem offerOrder)  throws Exception{
		boolean isCustomerOrderCreateFinished=true;
		//if this offerOrder is the Last OrderLine of Finished
		ICustomerOrder customerOrder=offerOrder.getCustomerOrder();
		Set<IOfferOrderItem> offerOrders=customerOrder.getOfferOrders();
		for (IOfferOrderItem aOfferOrder:offerOrders) {
			if(IOfferOrderItem.OfferOrderState.INITIATED.getValue() == aOfferOrder.getOfferOrderState()){
				isCustomerOrderCreateFinished=false;
				break;
			}
		}
		if(isCustomerOrderCreateFinished){
			Set<IProductOrderItem> productOrders=customerOrder.getProductOrders();
			for (IProductOrderItem aProductOrder:productOrders) {
				if(IProductOrderItem.ProductOrderState.INITIATED.getValue() == aProductOrder.getProductOrderState()){
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
	
	public boolean isCustomerOrderCreateFinishedOfLastProductOrder(IProductOrderItem productOrder)  throws Exception{
		boolean isCustomerOrderCreateFinished=true;
		//if this productOrder is the Last OrderLine of Finished
		ICustomerOrder customerOrder=productOrder.getCustomerOrder();
		Set<IProductOrderItem> productOrders=customerOrder.getProductOrders();
		for (IProductOrderItem aProductOrder:productOrders) {
			if(IProductOrderItem.ProductOrderState.INITIATED.getValue() == aProductOrder.getProductOrderState()){
				isCustomerOrderCreateFinished=false;
				break;
			}
		}
		if(isCustomerOrderCreateFinished){
			Set<IOfferOrderItem> offerOrders=customerOrder.getOfferOrders();
			for (IOfferOrderItem aOfferOrder:offerOrders) {
				if(IOfferOrderItem.OfferOrderState.INITIATED.getValue() == aOfferOrder.getOfferOrderState()){
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
	
	public boolean isOfferOrderCreateFinishedOfLastProductOrder(IProductOrderItem productOrder)  throws Exception{
		boolean isOfferOrderCreateFinished=true;
		//if this productOrder is the Last OrderLine of Finished
		Set<IProductOrderItem> productOrders=productOrder.getOfferOrder().getProductOrders();
		for (IProductOrderItem aProductOrder:productOrders) {
			if(IProductOrderItem.ProductOrderState.INITIATED.getValue() == aProductOrder.getProductOrderState()){
				isOfferOrderCreateFinished=false;
				break;
			}
		}
		if(isOfferOrderCreateFinished){
			productOrder.getOfferOrder().setOfferOrderState(IOfferOrderItem.OfferOrderState.CREATED.getValue());
			CreateOfferOrderFinished event=new CreateOfferOrderFinished(this);
			event.setOfferOrder(productOrder.getOfferOrder());
			eventPublisher.publishEvent(event);
		}
		return isOfferOrderCreateFinished;
	}	
	
	public boolean isSubmitOrder(ICustomerOrder customerOrder)  throws Exception{
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
