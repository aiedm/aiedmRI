package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;

public class CheckNewProductOrderPassed extends BaseEvent {
	private ProductOrderItemDTO productOrderDTO;
	public ProductOrderItemDTO getProductOrderDTO() {
		return productOrderDTO;
	}
	public void setProductOrderDTO(ProductOrderItemDTO productOrder) {
		this.productOrderDTO = productOrder;
	}
	public CheckNewProductOrderPassed(Object source) {
		super(source);
	}

}
