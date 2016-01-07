package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;

public class UnSubscribeProductOrderCreated extends BaseEvent {
	private ProductOrderItem productOrder;
	public ProductOrderItem getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(ProductOrderItem productOrder) {
		this.productOrder = productOrder;
	}
	public UnSubscribeProductOrderCreated(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
