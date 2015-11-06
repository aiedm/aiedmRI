package com.ai.crm.customerorder.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.impl.CustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.repository.interfaces.ICustomerOrderRepository;
@Component
public class CustomerOrderRepository implements ICustomerOrderRepository {

	public CustomerOrderRepository() {
	}

	@Override
	public void saveCustomerOrder(ICustomerOrder customerOrder) {

	}

	@Override
	public ICustomerOrder getCustomerOrderByID(long customerOrderId) {
		ICustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setCustomerOrderId(customerOrderId);
		return new CustomerOrder();
	}

}
