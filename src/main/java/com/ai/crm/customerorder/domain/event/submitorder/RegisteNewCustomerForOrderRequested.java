package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.CustomerOrder;

public class RegisteNewCustomerForOrderRequested extends BaseEvent {
	private CustomerOrder customerOrder;
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public RegisteNewCustomerForOrderRequested(Object source) {
		super(source);
	}

}
