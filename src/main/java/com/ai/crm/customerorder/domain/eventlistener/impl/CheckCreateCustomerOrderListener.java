package com.ai.crm.customerorder.domain.eventlistener.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;
import com.ai.common.rootentity.domain.model.impl.CheckResult;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderCheckFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderCheckFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderCheckFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderCheckFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderCustomerAvalibityCheckFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderCustomerAvalibityCheckFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderCustomerAvalibityCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.ICheckCreateCustomerOrderListener;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.upc.productoffering.domain.model.interfaces.IProductOffering;
import com.ai.upc.productoffering.domain.repository.interfaces.IProductOfferingRepository;
import com.ai.upc.productspecification.domian.model.interfaces.IProductSpecification;
import com.ai.upc.productspecification.domian.repository.interfaces.IProductSpecificationRepository;
@Component
public class CheckCreateCustomerOrderListener implements ICheckCreateCustomerOrderListener {
	public CheckCreateCustomerOrderListener(){
		
	}
	
	@Autowired
	private IPolicyExecute policyExecute;
	@Autowired
	private IEventPublisher eventPublisher;
	
	@Autowired
	private IProductOfferingRepository productOfferingRepository;
	@Autowired
	private IProductSpecificationRepository productSpecificationRepository;

	@EventListener
	public void onCreateOrderRequestedEvent(CreateOrderRequested event)  throws Exception{
		ICustomerOrder customerOrder = (ICustomerOrder)event.getCustomerOrder();
		Map<String,Object> context =new HashMap<String, Object>();
		context.put("CustomerOrder", customerOrder);
		CheckResult checkResult=policyExecute.executeCheckPolicy(event, null, context);
		if (checkResult.isError()){
			CreateOrderCustomerAvalibityCheckFailRejected event1=new CreateOrderCustomerAvalibityCheckFailRejected(this);
			event.setCustomerOrder(customerOrder);
			eventPublisher.publishEvent(event1);
		}else if (checkResult.isInformed()){
			CreateOrderCustomerAvalibityCheckFailInformed event2=new CreateOrderCustomerAvalibityCheckFailInformed(this);
			event.setCustomerOrder(customerOrder);
			eventPublisher.publishEvent(event2);
		}else{
			CreateOrderCustomerAvalibityCheckPassed event3=new CreateOrderCustomerAvalibityCheckPassed(this);
			event.setCustomerOrder(customerOrder);
			eventPublisher.publishEvent(event3);
		}
		
	}

	@EventListener
	public void onCreateNewOfferOrderRequestedEvent(CreateNewOfferOrderRequested event)  throws Exception{
		IOfferOrderItem offerOrder = (IOfferOrderItem)event.getOfferOrder();
		Map<String,Object> context =new HashMap<String, Object>();
		context.put("OfferOrder", offerOrder);
		IProductOffering productOffering=productOfferingRepository.getProductOfferingById(offerOrder.getToBeOfferInstance().getId());
		CheckResult checkResult=policyExecute.executeCheckPolicy(event, productOffering, context);
		if (checkResult.isError()){
			CreateNewOfferOrderCheckFailRejected event1=new CreateNewOfferOrderCheckFailRejected(this);
			event.setOfferOrder(offerOrder);
			eventPublisher.publishEvent(event1);
		}else if (checkResult.isInformed()){
			CreateNewOfferOrderCheckFailInformed event2=new CreateNewOfferOrderCheckFailInformed(this);
			event.setOfferOrder(offerOrder);
			eventPublisher.publishEvent(event2);
		}else{
			CreateNewOfferOrderCheckPassed event3=new CreateNewOfferOrderCheckPassed(this);
			event.setOfferOrder(offerOrder);
			eventPublisher.publishEvent(event3);
		}
	}

	@EventListener
	public void onCreateNewProductOrderRequestedEvent(CreateNewProductOrderRequested event)  throws Exception{
		IProductOrderItem productOrder = (IProductOrderItem)event.getProductOrder();
		Map<String,Object> context =new HashMap<String, Object>();
		context.put("ProductOrder", productOrder);	
		IProductSpecification productSpecification = productSpecificationRepository.getProductSpecificationById(productOrder.getToBeProduct().getProductSpecificationId());
		CheckResult checkResult=policyExecute.executeCheckPolicy(event, productSpecification, context);
		if (checkResult.isError()){
			CreateNewProductOrderCheckFailRejected event1=new CreateNewProductOrderCheckFailRejected(this);
			event.setProductOrder(productOrder);
			eventPublisher.publishEvent(event1);
		}else if (checkResult.isInformed()){
			CreateNewProductOrderCheckFailInformed event2=new CreateNewProductOrderCheckFailInformed(this);
			event.setProductOrder(productOrder);
			eventPublisher.publishEvent(event2);
		}else{
			CreateNewProductOrderCheckPassed event3=new CreateNewProductOrderCheckPassed(this);
			event.setProductOrder(productOrder);
			eventPublisher.publishEvent(event3);
		}	}

}
