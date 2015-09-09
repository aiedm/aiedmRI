package com.ai.crm.customerorder.domain.event;

import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.flyingshuttle.base.BaseEvent;

public class CreateNewProductOrderCheckFailInformed extends BaseEvent {
	private IProductOrder productOrder;
	public IProductOrder getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(IProductOrder productOrder) {
		this.productOrder = productOrder;
	}
	public CreateNewProductOrderCheckFailInformed(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
