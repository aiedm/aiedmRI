package com.ai.crm.customerorder.repository.interfaces;

import com.ai.crm.customerorder.domain.model.CustomerOrder;

public interface ICustomerOrderRepository {
	void saveCustomerOrder(CustomerOrder customerOrder) throws Exception;
	CustomerOrder getCustomerOrderByID(long customerOrderId)  throws Exception;
	public CustomerOrder createNewCustomerOrder(CustomerOrder customerOrder) throws Exception;
}
