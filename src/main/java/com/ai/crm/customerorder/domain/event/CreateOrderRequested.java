package com.ai.crm.customerorder.domain.event;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.flyingshuttle.base.BaseEvent;

public class CreateOrderRequested extends BaseEvent {
	private ICustomerOrder customerOrder;

	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public CreateOrderRequested(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
