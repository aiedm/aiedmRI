package com.ai.crm.customerorder.domain.eventlistener.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;
import com.ai.common.rootentity.domain.model.impl.CheckResult;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderPassed;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewProductOrderFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewProductOrderFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewProductOrderPassed;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.ICheckCreateCustomerOrderListener;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
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
		CustomerOrderDTO customerOrder = (CustomerOrderDTO)event.getCustomerOrderDTO();
		Map<String,Object> context =new HashMap<String, Object>();
		context.put("CustomerOrder", customerOrder);
		CheckResult checkResult=policyExecute.executeCheckPolicy(event, null, context);		
		Set<OfferOrderItemDTO> offerOrderItems=customerOrder.getOfferOrderItems();
		if(offerOrderItems.size()>0){
			for (OfferOrderItemDTO offerOrderItemDTO : offerOrderItems) {
				CheckNewOfferOrderRequested eventCreateNewOfferOrder=new CheckNewOfferOrderRequested(this);
				eventCreateNewOfferOrder.setOfferOrderDTO(offerOrderItemDTO);
				eventPublisher.publishEvent(eventCreateNewOfferOrder);
				CheckResult offerCheckResult=eventCreateNewOfferOrder.getCheckResult();
				Set<String> errMsg=offerCheckResult.getErrorInfomations();
				if(errMsg.size()>0){
					checkResult.getErrorInfomations().addAll(errMsg);
				}
				Set<String> informMsg=offerCheckResult.getInformInfomations();
				if(informMsg.size()>0){
					checkResult.getInformInfomations().addAll(informMsg);
				}
			}
		}
		Set<ProductOrderItemDTO> productOrders=customerOrder.getProductOrderItems();
		if(productOrders.size()>0){
			for (ProductOrderItemDTO productOrderItemDTO : productOrders) {
				CheckNewProductOrderRequested eventCreateNewProductOrder=new CheckNewProductOrderRequested(this);
				eventCreateNewProductOrder.setProductOrderDTO(productOrderItemDTO);
				eventPublisher.publishEvent(eventCreateNewProductOrder);
				CheckResult offerCheckResult=eventCreateNewProductOrder.getCheckResult();
				Set<String> errMsg=offerCheckResult.getErrorInfomations();
				if(errMsg.size()>0){
					checkResult.getErrorInfomations().addAll(errMsg);
				}
				Set<String> informMsg=offerCheckResult.getInformInfomations();
				if(informMsg.size()>0){
					checkResult.getInformInfomations().addAll(informMsg);
				}
			}
		}
		if (checkResult.isError()){
			CheckOrderCustomerAvalibityFailRejected event1=new CheckOrderCustomerAvalibityFailRejected(this);
			event1.setCustomerOrderDTO(customerOrder);
			eventPublisher.publishEvent(event1);
		}else if (checkResult.isInformed()){
			CheckOrderCustomerAvalibityFailInformed event2=new CheckOrderCustomerAvalibityFailInformed(this);
			event2.setCustomerOrderDTO(customerOrder);
			eventPublisher.publishEvent(event2);
		}else{
			CheckOrderCustomerAvalibityPassed event3=new CheckOrderCustomerAvalibityPassed(this);
			event3.setCustomerOrderDTO(customerOrder);
			eventPublisher.publishEvent(event3);
		}
	}

	@EventListener
	public void onCreateNewOfferOrderRequestedEvent(CheckNewOfferOrderRequested event)  throws Exception{
		OfferOrderItemDTO offerOrderItemDTO=event.getOfferOrderDTO();
		Map<String,Object> context =new HashMap<String, Object>();
		context.put("OfferOrder", offerOrderItemDTO);
		ToBeOfferInstanceDTO toBeOfferInstance =offerOrderItemDTO.getToBeOfferInstanceTDO();
		IProductOffering productOffering=productOfferingRepository.getProductOfferingById(toBeOfferInstance.getProductOffferingId());
		CheckResult checkResult=policyExecute.executeCheckPolicy(event, productOffering, context);
		event.setCheckResult(checkResult);
		if (checkResult.isError()){
			CheckNewOfferOrderFailRejected event1=new CheckNewOfferOrderFailRejected(this);
			event1.setOfferOrderDTO(offerOrderItemDTO);
			eventPublisher.publishEvent(event1);
		}else if (checkResult.isInformed()){
			CheckNewOfferOrderFailInformed event2=new CheckNewOfferOrderFailInformed(this);
			event2.setOfferOrderDTO(offerOrderItemDTO);
			eventPublisher.publishEvent(event2);
		}else{
			CheckNewOfferOrderPassed event3=new CheckNewOfferOrderPassed(this);
			event3.setOfferOrderDTO(offerOrderItemDTO);
			eventPublisher.publishEvent(event3);
		}
	}

	@EventListener
	public void onCreateNewProductOrderRequestedEvent(CheckNewProductOrderRequested event)  throws Exception{
		ProductOrderItemDTO productOrder = event.getProductOrderDTO();
		Map<String,Object> context =new HashMap<String, Object>();
		context.put("ProductOrder", productOrder);
		IToBeProduct toBeProduct = (IToBeProduct)productOrder.getToBeProductDTO();
		IProductSpecification productSpecification = productSpecificationRepository.getProductSpecificationById(toBeProduct.getProductSpecificationId());
		CheckResult checkResult=policyExecute.executeCheckPolicy(event, productSpecification, context);
		event.setCheckResult(checkResult);
		if (checkResult.isError()){
			CheckNewProductOrderFailRejected event1=new CheckNewProductOrderFailRejected(this);
			event1.setProductOrderDTO(productOrder);
			eventPublisher.publishEvent(event1);
		}else if (checkResult.isInformed()){
			CheckNewProductOrderFailInformed event2=new CheckNewProductOrderFailInformed(this);
			event2.setProductOrderDTO(productOrder);
			eventPublisher.publishEvent(event2);
		}else{
			CheckNewProductOrderPassed event3=new CheckNewProductOrderPassed(this);
			event3.setProductOrderDTO(productOrder);
			eventPublisher.publishEvent(event3);
		}	}

}
