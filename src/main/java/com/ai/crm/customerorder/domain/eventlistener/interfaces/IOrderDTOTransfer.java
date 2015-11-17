package com.ai.crm.customerorder.domain.eventlistener.interfaces;

import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.domain.model.CustomerOrder;

public interface IOrderDTOTransfer {
	CustomerOrder transformNewDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception;
	CustomerOrder transformUpdateDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception;
}
