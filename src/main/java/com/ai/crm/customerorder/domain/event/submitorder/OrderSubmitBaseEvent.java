package com.ai.crm.customerorder.domain.event.submitorder;

import java.util.Set;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;


public abstract class OrderSubmitBaseEvent extends BaseEvent {
	private CustomerOrder customerOrder;
	//did not decompose to product order item
	private Set<OfferOrderItem> offerOrderItems;
	private Set<ToBeOfferInstance> toBeOfferInstances;
	public Set<OfferOrderItem> getOfferOrderItems() {
		return offerOrderItems;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public Set<ToBeOfferInstance> getToBeOfferInstances() {
		return toBeOfferInstances;
	}
	
	public OrderSubmitBaseEvent(Object source) {
		super(source);
	}

}
