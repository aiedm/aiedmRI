package com.ai.crm.customerorder.domain.event.submitorder;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;

public class NewAccountForOrderCreated extends BaseEvent {
	private ICustomerOrder customerOrder;
	private long customerAccountId;
	public long getCustomerAccountId() {
		return customerAccountId;
	}
	public void setCustomerAccountId(long customerAccountId) {
		this.customerAccountId = customerAccountId;
	}
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public NewAccountForOrderCreated(Object source) {
		super(source);
	}

}
