package com.ai.crm.customerorder.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.repository.interfaces.ICustomerOrderRepository;
@Component
public class CustomerOrderRepository implements ICustomerOrderRepository {

	public CustomerOrderRepository() {
	}

	@Override
	public void saveCustomerOrder(ICustomerOrder customerOrder) {

	}

}
