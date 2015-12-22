package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.CustomerOrder;

public class NewAccountForOrderCreated extends BaseEvent {
	private CustomerOrder customerOrder;
	private long customerAccountId;
	public long getCustomerAccountId() {
		return customerAccountId;
	}
	public void setCustomerAccountId(long customerAccountId) {
		this.customerAccountId = customerAccountId;
	}
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public NewAccountForOrderCreated(Object source) {
		super(source);
	}

}
