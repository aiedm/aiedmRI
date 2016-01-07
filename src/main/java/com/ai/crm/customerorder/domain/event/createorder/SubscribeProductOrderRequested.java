package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;

public class SubscribeProductOrderRequested extends BaseEvent {
	private ProductOrderItem productOrder;
	public ProductOrderItem getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(ProductOrderItem productOrder) {
		this.productOrder = productOrder;
	}
	public SubscribeProductOrderRequested(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
