package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ProductOrderItem extends CustomerOrderItem implements IProductOrderItem {

	private long productOrderId;
	
	@JsonIgnore
	private ICustomerOrder customerOrder;
	
	public ProductOrderItem() {
	}
	
	public ProductOrderItem(ICustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
		customerOrder.addProductOrder(this);
	}	
	

	@Override
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	@Override
	public long getProductOrderId() {
		return productOrderId;
	}

	@Override
	public long getBusinessInteractionSpecificationId() {
		//TODO
		return 0;
	}

	@Override
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder=customerOrder;
		
	}

	@Override
	public void setProductOrderId(long productOrderId) {
		this.productOrderId=productOrderId;
		
	}

	@Override
	public int getProductOrderState() {
		return this.getBiiState();
	}

	@Override
	public void setProductOrderState(int productOrderState) {
		this.setBiiState(productOrderState);		
	}	
}
