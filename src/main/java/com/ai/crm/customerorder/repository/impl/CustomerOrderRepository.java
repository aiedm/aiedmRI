package com.ai.crm.customerorder.repository.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateCustomerOrder;
import com.ai.crm.customerorder.repository.interfaces.ICustomerOrderRepository;
@Component
public class CustomerOrderRepository implements ICustomerOrderRepository {
	@Autowired
	private ICreateCustomerOrder CreateCustomerOrder ;
	@Autowired
	SessionFactory sessionFactory;
	
	public CustomerOrderRepository() {
	}
	
	public CustomerOrderRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public CustomerOrder createNewCustomerOrder(CustomerOrder customerOrder) throws Exception{
		Serializable id = currentSession().getIdentifier(customerOrder);
		customerOrder.setCustomerOrderId((Long)id);
		customerOrder.setCustomerOrderCode(CreateCustomerOrder.generateCustomerOrderCode());
		return customerOrder;
	}

	@Override
	public void saveCustomerOrder(CustomerOrder customerOrder) {
		currentSession().save(customerOrder);
	}

	@Override
	public CustomerOrder getCustomerOrderByID(long customerOrderId)  throws Exception{
		CustomerOrder customerOrder= (CustomerOrder)currentSession().get(CustomerOrder.class, customerOrderId);
		return customerOrder;
	}

}
