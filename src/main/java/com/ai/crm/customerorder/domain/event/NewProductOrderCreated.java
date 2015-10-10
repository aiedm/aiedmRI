package com.ai.crm.customerorder.domain.event;

import com.ai.common.rootentity.domain.model.interfaces.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;

public class NewProductOrderCreated extends BaseEvent {
	private IProductOrderItem productOrder;
	public IProductOrderItem getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(IProductOrderItem productOrder) {
		this.productOrder = productOrder;
	}
	public NewProductOrderCreated(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
