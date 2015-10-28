package com.ai.crm.customerorder.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.impl.CheckResult;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderCheckFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderCheckFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewOfferOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderCheckFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderCheckFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CreateNewProductOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderCustomerAvalibityCheckFailInformed;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderCustomerAvalibityCheckFailRejected;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderCustomerAvalibityCheckPassed;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.service.interfaces.ICheckCreateCustomerOrder;
@Component
public class CheckCreateCustomerOrder implements ICheckCreateCustomerOrder {
	public CheckCreateCustomerOrder(){
		
	}
	@Autowired
	private IEventPublisher eventPublisher;
	
	public CheckResult checkCreateNewOrderCustomerAvalibity(ICustomerOrder customerOrder)  throws Exception{
		CheckResult checkResult=new CheckResult();
		if (checkResult.isError()){
			CreateOrderCustomerAvalibityCheckFailRejected event=new CreateOrderCustomerAvalibityCheckFailRejected(this);
			event.setCustomerOrder(customerOrder);
			eventPublisher.publishEvent(event);
		}else if (checkResult.isInformed()){
			CreateOrderCustomerAvalibityCheckFailInformed event=new CreateOrderCustomerAvalibityCheckFailInformed(this);
			event.setCustomerOrder(customerOrder);
			eventPublisher.publishEvent(event);
		}else{
			CreateOrderCustomerAvalibityCheckPassed event=new CreateOrderCustomerAvalibityCheckPassed(this);
			event.setCustomerOrder(customerOrder);
			eventPublisher.publishEvent(event);
		}
		return checkResult;
	}

	public CheckResult checkCreateNewOfferOrderAvalibity(IOfferOrderItem offerOrder)  throws Exception{
		CheckResult checkResult=new CheckResult();
		if (checkResult.isError()){
			CreateNewOfferOrderCheckFailRejected event=new CreateNewOfferOrderCheckFailRejected(this);
			event.setOfferOrder(offerOrder);
			eventPublisher.publishEvent(event);
		}else if (checkResult.isInformed()){
			CreateNewOfferOrderCheckFailInformed event=new CreateNewOfferOrderCheckFailInformed(this);
			event.setOfferOrder(offerOrder);
			eventPublisher.publishEvent(event);
		}else{
			CreateNewOfferOrderCheckPassed event=new CreateNewOfferOrderCheckPassed(this);
			event.setOfferOrder(offerOrder);
			eventPublisher.publishEvent(event);
		}
		return checkResult;
	}

	public CheckResult checkCreateNewProductOrderAvalibity(IProductOrderItem productOrder)  throws Exception{
		CheckResult checkResult=new CheckResult();
		if (checkResult.isError()){
			CreateNewProductOrderCheckFailRejected event=new CreateNewProductOrderCheckFailRejected(this);
			event.setProductOrder(productOrder);
			eventPublisher.publishEvent(event);
		}else if (checkResult.isInformed()){
			CreateNewProductOrderCheckFailInformed event=new CreateNewProductOrderCheckFailInformed(this);
			event.setProductOrder(productOrder);
			eventPublisher.publishEvent(event);
		}else{
			CreateNewProductOrderCheckPassed event=new CreateNewProductOrderCheckPassed(this);
			event.setProductOrder(productOrder);
			eventPublisher.publishEvent(event);
		}
		return checkResult;
	}

}
