package com.ai.crm.customerorder.domain.event;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;

public class CreateOrderCustomerAvalibityCheckFailRejected extends BaseEvent {
	private ICustomerOrder customerOrder;

	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public CreateOrderCustomerAvalibityCheckFailRejected(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
