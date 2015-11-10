package com.ai.crm.customerorder.domain.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ProductOrderItem extends CustomerOrderItem{

	private long productOrderId;
	
	private CustomerOrder customerOrder;
	
	public ProductOrderItem() {
	}
	
	public ProductOrderItem(CustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
		customerOrder.addProductOrder(this);
	}	
	

	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	
	public long getProductOrderId() {
		return productOrderId;
	}

	
	public long getBusinessInteractionSpecificationId() {
		//TODO
		return 0;
	}

	
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder=customerOrder;
		
	}

	
	public void setProductOrderId(long productOrderId) {
		this.productOrderId=productOrderId;
		
	}

	
	public int getProductOrderState() {
		return this.getBiiState();
	}

	
	public void setProductOrderState(int productOrderState) {
		this.setBiiState(productOrderState);		
	}	
}
