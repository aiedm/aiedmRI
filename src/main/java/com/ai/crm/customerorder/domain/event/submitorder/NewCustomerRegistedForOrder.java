package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;

public class NewCustomerRegistedForOrder extends BaseEvent {
	private ICustomerOrder customerOrder;
	private long customerId; 
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public NewCustomerRegistedForOrder(Object source) {
		super(source);
	}

}
