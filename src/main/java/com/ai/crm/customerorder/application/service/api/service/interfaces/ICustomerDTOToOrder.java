package com.ai.crm.customerorder.application.service.api.service.interfaces;

import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.domain.model.CustomerOrder;

public interface ICustomerDTOToOrder {
	CustomerOrder transDTOToOrder(CustomerOrderDTO customerOrderDTO,CustomerOrder customerOrder) throws Exception;
}
