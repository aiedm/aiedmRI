package com.ai.crm.customerorder.repository.interfaces;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;

public interface ICustomerOrderRepository {
	void saveCustomerOrder(ICustomerOrder customerOrder);
	ICustomerOrder getCustomerOrderByID(long customerOrderId);
}
