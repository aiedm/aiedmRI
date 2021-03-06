package com.ai.crm.customerorder.domain.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
import com.ai.crm.customerorder.domain.event.createorder.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.SubscribeOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.SubscribeProductOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.UnSubscribeOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.UnSubscribeProductOrderRequested;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.customerorder.domain.model.ShoppingCart;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
import com.ai.crm.customerorder.domain.service.interfaces.IOrderDTOTransfer;
import com.ai.crm.customerorder.repository.interfaces.ICustomerOrderRepository;
@Component
//@Transactional
public class CreateCustomerOrder implements ICreateCustomerOrder {
	public CreateCustomerOrder(){
		
	}
	@Autowired
	private IEventPublisher eventPublisher;
	@Autowired
	private IOrderDTOTransfer orderDTOTransfer;
	@Autowired
	private ICustomerOrderRepository customerOrderRepository;
	
	@Override
	public void createCustomerOrder(CheckOrderCustomerAvalibityPassed event)  throws Exception{
		CustomerOrderDTO customerOrderDTO=event.getCustomerOrderDTO();
		CustomerOrder customerOrder=orderDTOTransfer.transformNewDTO2Order(customerOrderDTO);
		customerOrder.setOrderState(CustomerOrder.CustomerOrderState.CREATED.getValue());
		CustomerOrderCreated newEvent=new CustomerOrderCreated(this);
		newEvent.setCustomerOrder(customerOrder);
		eventPublisher.publishEvent(newEvent);
		if(event.getShoppingCartId()>0){
			this.createCustomerOrder(customerOrder,event.getShoppingCartId());
		}
		customerOrderDTO.setCustomerOrderId(customerOrder.getCustomerOrderId());
		customerOrderDTO.setCustomerOrderCode(customerOrder.getCustomerOrderCode());		
	}
	
	@Override
	public void distributeOrderItemCreate(CustomerOrder customerOrder)  throws Exception{
		//OfferOrderItem
		Set<OfferOrderItem> offerOrders=customerOrder.getOfferOrders();
		for (OfferOrderItem offerOrder:offerOrders) {
			if(null==offerOrder.getCustomerOrder()){
				offerOrder.setCustomerOrder(customerOrder);
			}
			long biiSpecId=offerOrder.getBusinessInteractionItemSpecId();
			//BusinessInteractionItemSpec biiSpec=
			//TODO replace with real newConnectionCode
			if(biiSpecId==1001){
				SubscribeOfferOrderRequested event=new SubscribeOfferOrderRequested(this);
				event.setOfferOrder(offerOrder);
				eventPublisher.publishEvent(event);
			}else if (biiSpecId==1002){
				//unsubscriber
				UnSubscribeOfferOrderRequested event=new UnSubscribeOfferOrderRequested(this);
				event.setOfferOrder(offerOrder);
				eventPublisher.publishEvent(event);
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
				SubscribeProductOrderRequested event=new SubscribeProductOrderRequested(this);
				event.setProductOrder(productOrder);
				eventPublisher.publishEvent(event);
			}else if (biiSpecId==2002){
				//unsubscriber
				UnSubscribeProductOrderRequested event=new UnSubscribeProductOrderRequested(this);
				event.setProductOrder(productOrder);
				eventPublisher.publishEvent(event);
			}else if (biiSpecId==2003){
				//modify
			}
		}		
	}
	
	@Override
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
	
	@Override
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

	@Override
	public void saveCustomerOrder(CustomerOrder customerOrder) throws Exception {
		customerOrderRepository.saveCustomerOrder(customerOrder);
		if(!(customerOrder instanceof ShoppingCart)){
			this.startOrder(customerOrder);
		}
		
	}	
	
}
