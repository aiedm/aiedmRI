package com.ai.crm.customerorder.domain.eventlistener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.application.service.api.adapter.interfaces.ICustomerDTOToOrder;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.IOrderDTOTransfer;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.repository.interfaces.ICustomerOrderRepository;
@Component
public class OrderDTOTransfer implements IOrderDTOTransfer{
	@Autowired
	private ICustomerDTOToOrder customerDTOToOrder;
	@Autowired
	private ICustomerOrderRepository customerOrderRepository;
	@Override
	public CustomerOrder transformNewDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception{
		CustomerOrder customerOrder=new CustomerOrder(customerOrderDTO.getBusinessInteractionSpecId());
		return customerDTOToOrder.transDTOToOrder(customerOrderDTO,customerOrder);
	}
	

	public CustomerOrder transformUpdateDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception{
		if(customerOrderDTO.getCustomerId()<=0){
			throw new Exception("Customer Order Id can not be null!");
		}
		CustomerOrder customerOrder = customerOrderRepository.getCustomerOrderByID(customerOrderDTO.getCustomerOrderId());
		
		return customerOrder;
	}
	
}
