package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;

public class NewProductOrderRequested extends BaseEvent {
	private IProductOrderItem productOrder;
	public IProductOrderItem getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(IProductOrderItem productOrder) {
		this.productOrder = productOrder;
	}
	public NewProductOrderRequested(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
