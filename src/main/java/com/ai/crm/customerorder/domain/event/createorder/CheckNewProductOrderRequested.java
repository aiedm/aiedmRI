package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.common.rootentity.domain.model.CheckResult;
import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;

public class CheckNewProductOrderRequested extends BaseEvent {

	private ProductOrderItemDTO productOrderDTO;
	private CheckResult checkResult;
	public ProductOrderItemDTO getProductOrderDTO() {
		return productOrderDTO;
	}
	public void setProductOrderDTO(ProductOrderItemDTO productOrder) {
		this.productOrderDTO = productOrder;
	}
	public CheckNewProductOrderRequested(Object source) {
		super(source);
	}
	public CheckResult getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(CheckResult checkResult) {
		this.checkResult = checkResult;
	}

}
