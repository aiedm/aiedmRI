package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.CustomerOrder;

public class CreateNewAccountForOrderRequested extends BaseEvent{
	private CustomerOrder customerOrder;
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public CreateNewAccountForOrderRequested(Object source) {
		super(source);
	}

}
