package com.ai.crm.customerorder.domain.event;

import com.ai.common.rootentity.domain.model.interfaces.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;

public class CreateCustomerOrderFinished extends BaseEvent {
	private ICustomerOrder customerOrder;
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public CreateCustomerOrderFinished(Object source) {
		super(source);
	}

}
