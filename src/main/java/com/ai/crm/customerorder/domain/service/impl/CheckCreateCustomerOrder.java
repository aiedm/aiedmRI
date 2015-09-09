package com.ai.crm.customerorder.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.event.CreateNewOfferOrderCheckFailInformed;
import com.ai.crm.customerorder.domain.event.CreateNewOfferOrderCheckFailRejected;
import com.ai.crm.customerorder.domain.event.CreateNewOfferOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.CreateNewProductOrderCheckFailInformed;
import com.ai.crm.customerorder.domain.event.CreateNewProductOrderCheckFailRejected;
import com.ai.crm.customerorder.domain.event.CreateNewProductOrderCheckPassed;
import com.ai.crm.customerorder.domain.event.CreateOrderCustomerAvalibityCheckFailInformed;
import com.ai.crm.customerorder.domain.event.CreateOrderCustomerAvalibityCheckFailRejected;
import com.ai.crm.customerorder.domain.event.CreateOrderCustomerAvalibityCheckPassed;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.service.interfaces.ICheckCreateCustomerOrder;
import com.ai.flyingshuttle.base.service.impl.CheckResult;
import com.ai.flyingshuttle.base.service.interfaces.IEventPublisher;
@Component
public class CheckCreateCustomerOrder implements ICheckCreateCustomerOrder {
	public CheckCreateCustomerOrder(){
		
	}
	@Autowired
	private IEventPublisher eventPublisher;
	
	public CheckResult checkCreateNewOrderCustomerAvalibity(ICustomerOrder customerOrder) {
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

	public CheckResult checkCreateNewOfferOrderAvalibity(IOfferOrder offerOrder) {
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

	public CheckResult checkCreateNewProductOrderAvalibity(IProductOrder productOrder) {
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
