package com.ai.crm.customerorder.domain.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
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
//@Transactional
public class CreateCustomerOrder implements ICreateCustomerOrder {
	public CreateCustomerOrder(){
		
	}
	@Autowired
	private IEventPublisher eventPublisher;
		
	public void createCustomerOrder(CustomerOrder customerOrder)  throws Exception{
		if(customerOrder.getCustomerOrderId()==0){
			
		}
		customerOrder.setOrderState(CustomerOrder.CustomerOrderState.CREATED.getValue());
		CustomerOrderCreated event=new CustomerOrderCreated(this);
		event.setCustomerOrder(customerOrder);
		eventPublisher.publishEvent(event);
	}

	public void createNewOfferOrder(OfferOrderItem offerOrder)  throws Exception{
		offerOrder.setOfferOrderState(OfferOrderItem.OfferOrderState.CREATED.getValue());
		NewOfferOrderCreated event=new NewOfferOrderCreated(this);
		event.setOfferOrder(offerOrder);
		eventPublisher.publishEvent(event);
	}
	

	public void createNewProductOrder(ProductOrderItem productOrder)  throws Exception{
		productOrder.setProductOrderState(ProductOrderItem.ProductOrderState.CREATED.getValue());
		//deal with subscriber
		
		NewProductOrderCreated event=new NewProductOrderCreated(this);
		event.setProductOrder(productOrder);
		eventPublisher.publishEvent(event);
	}
	
	public void distributeOrderItemCreate(CustomerOrder customerOrder)  throws Exception{
		//OfferOrderItem
		Set<OfferOrderItem> offerOrders=customerOrder.getOfferOrders();
		for (OfferOrderItem offerOrder:offerOrders) {
			if(null==offerOrder.getCustomerOrder()){
				offerOrder.setCustomerOrder(customerOrder);
			}
			long biiSpecId=offerOrder.getBusinessInteractionItemSpecId();
			//TODO replace with real newConnectionID
			if(biiSpecId==1001){
				NewOfferOrderRequested event=new NewOfferOrderRequested(this);
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
		Set<ProductOrderItem> productOrders=customerOrder.getProductOrders();
		for (ProductOrderItem productOrder:productOrders) {
			if(null==productOrder.getCustomerOrder()){
				productOrder.setCustomerOrder(customerOrder);
			}
			long biiSpecId=productOrder.getBusinessInteractionItemSpecId();
			//TODO replace with real newConnectionID
			if(biiSpecId==2001){
				NewProductOrderRequested event=new NewProductOrderRequested(this);
				event.setProductOrder(productOrder);
				eventPublisher.publishEvent(event);
			}else if (biiSpecId==2002){
				//unsubscriber
			}else if (biiSpecId==2003){
				//modify
			}
		}		
	}
	
	public boolean isCustomerOrderCreateFinishedOfLastOfferOrder(OfferOrderItem offerOrder)  throws Exception{
		boolean isCustomerOrderCreateFinished=true;
		//if this offerOrder is the Last OrderLine of Finished
		CustomerOrder customerOrder=offerOrder.getCustomerOrder();
		Set<OfferOrderItem> offerOrders=customerOrder.getOfferOrders();
		for (OfferOrderItem aOfferOrder:offerOrders) {
			if(OfferOrderItem.OfferOrderState.INITIATED.getValue() == aOfferOrder.getOfferOrderState()){
				isCustomerOrderCreateFinished=false;
				break;
			}
		}
		if(isCustomerOrderCreateFinished){
			Set<ProductOrderItem> productOrders=customerOrder.getProductOrders();
			for (ProductOrderItem aProductOrder:productOrders) {
				if(ProductOrderItem.ProductOrderState.INITIATED.getValue() == aProductOrder.getProductOrderState()){
					isCustomerOrderCreateFinished=false;
					break;
				}
			}	
		}
		if(isCustomerOrderCreateFinished){
			offerOrder.getCustomerOrder().setOrderState(CustomerOrder.CustomerOrderState.CREATED.getValue());
			CreateCustomerOrderFinished event=new CreateCustomerOrderFinished(this);
			event.setCustomerOrder(offerOrder.getCustomerOrder());
			eventPublisher.publishEvent(event);
		}
		return isCustomerOrderCreateFinished;
	}
	
	public boolean isCustomerOrderCreateFinishedOfLastProductOrder(ProductOrderItem productOrder)  throws Exception{
		boolean isCustomerOrderCreateFinished=true;
		//if this productOrder is the Last OrderLine of Finished
		CustomerOrder customerOrder=productOrder.getCustomerOrder();
		Set<ProductOrderItem> productOrders=customerOrder.getProductOrders();
		for (ProductOrderItem aProductOrder:productOrders) {
			if(ProductOrderItem.ProductOrderState.INITIATED.getValue() == aProductOrder.getProductOrderState()){
				isCustomerOrderCreateFinished=false;
				break;
			}
		}
		if(isCustomerOrderCreateFinished){
			Set<OfferOrderItem> offerOrders=customerOrder.getOfferOrders();
			for (OfferOrderItem aOfferOrder:offerOrders) {
				if(OfferOrderItem.OfferOrderState.INITIATED.getValue() == aOfferOrder.getOfferOrderState()){
					isCustomerOrderCreateFinished=false;
					break;
				}
			}
		}
		if(isCustomerOrderCreateFinished){
			productOrder.getCustomerOrder().setOrderState(CustomerOrder.CustomerOrderState.CREATED.getValue());
			CreateCustomerOrderFinished event=new CreateCustomerOrderFinished(this);
			event.setCustomerOrder(productOrder.getCustomerOrder());
			eventPublisher.publishEvent(event);
		}
		return isCustomerOrderCreateFinished;
	}
	

	@Override
	public void createCustomerOrder(CustomerOrder customerOrder, long shoppingCartId) throws Exception {
		
		
	}

	@Override
	public void startOrder(CustomerOrder customerOrder) throws Exception{
		
		
	}

	@Override
	public String generateCustomerOrderCode() throws Exception {
		StringBuffer sb=new StringBuffer();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date=new Date();
		sb.append(dateFormater.format(date));
		return sb.toString();
	}	
	
}
