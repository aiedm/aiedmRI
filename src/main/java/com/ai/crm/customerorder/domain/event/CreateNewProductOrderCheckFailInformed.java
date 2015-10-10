package com.ai.crm.customerorder.domain.event;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;

public class CreateNewProductOrderCheckFailInformed extends BaseEvent {
	private IProductOrderItem productOrder;
	public IProductOrderItem getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(IProductOrderItem productOrder) {
		this.productOrder = productOrder;
	}
	public CreateNewProductOrderCheckFailInformed(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
