package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;

public class NewProductOrderCreated extends BaseEvent {
	private ProductOrderItem productOrder;
	public ProductOrderItem getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(ProductOrderItem productOrder) {
		this.productOrder = productOrder;
	}
	public NewProductOrderCreated(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
