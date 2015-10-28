package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;

public class CreateNewAccountForOrderRequested extends BaseEvent{
	private ICustomerOrder customerOrder;
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public CreateNewAccountForOrderRequested(Object source) {
		super(source);
	}

}
