package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.CustomerOrder;

public class NewCustomerRegistedForOrder extends BaseEvent {
	private CustomerOrder customerOrder;
	private long customerId; 
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public NewCustomerRegistedForOrder(Object source) {
		super(source);
	}

}
