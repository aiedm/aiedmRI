package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;

public class CheckOrderCustomerAvalibityPassed extends BaseEvent {
	private long shoppingCartId;

	public long getShoppingCartId() {
		return shoppingCartId;
	}

	private CustomerOrderDTO customerOrderDTO;

	public CustomerOrderDTO getCustomerOrderDTO() {
		return customerOrderDTO;
	}

	public void setCustomerOrderDTO(CustomerOrderDTO customerOrder) {
		this.customerOrderDTO = customerOrder;
	}

	public CheckOrderCustomerAvalibityPassed(Object source) {
		super(source);
	}

}
