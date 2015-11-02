package com.ai.crm.customerorder.domain.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateOfferOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewProductOrderCreated;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IShoppingCart;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
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
	

	@Override
	public void createCustomerOrder(ICustomerOrder customerOrder, long shoppingCartId) throws Exception {
		
		
	}

	@Override
	public void startOrder(ICustomerOrder customerOrder) throws Exception{
		
		
	}	
	
}
