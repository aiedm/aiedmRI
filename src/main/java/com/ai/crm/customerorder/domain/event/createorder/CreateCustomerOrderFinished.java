package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
public class CreateCustomerOrderFinished extends BaseEvent {
	private CustomerOrder customerOrder;
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public CreateCustomerOrderFinished(Object source) {
		super(source);
	}

}
