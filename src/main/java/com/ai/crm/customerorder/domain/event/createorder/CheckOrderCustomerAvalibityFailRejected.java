package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;

public class CheckOrderCustomerAvalibityFailRejected extends BaseEvent {
	private CustomerOrderDTO customerOrderDTO;

	public CustomerOrderDTO getCustomerOrderDTO() {
		return customerOrderDTO;
	}

	public void setCustomerOrderDTO(CustomerOrderDTO customerOrder) {
		this.customerOrderDTO = customerOrder;
	}
	public CheckOrderCustomerAvalibityFailRejected(Object source) {
		super(source);
	}

}
