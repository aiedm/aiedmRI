package com.ai.crm.customerorder.domain.eventlistener.interfaces;

import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;

public interface IOrderDTOTransfer {
	ICustomerOrder transformNewDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception;
	ICustomerOrder transformUpdateDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception;
	ICustomerOrder transformCancelDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception;
}
