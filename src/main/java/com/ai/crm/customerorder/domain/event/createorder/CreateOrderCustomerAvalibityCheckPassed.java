package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;

public class CreateOrderCustomerAvalibityCheckPassed extends BaseEvent {
	private ICustomerOrder customerOrder;
	private long shoppingCartId;

	public long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public CreateOrderCustomerAvalibityCheckPassed(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
