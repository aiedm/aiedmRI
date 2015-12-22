package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.CustomerOrder;

public class CustomerOrderCreated extends BaseEvent {
	private CustomerOrder customerOrder;

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public CustomerOrderCreated(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
