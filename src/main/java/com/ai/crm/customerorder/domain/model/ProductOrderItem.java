package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class ProductOrderItem extends CustomerOrderItem{
	public enum ProductOrderState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		DELIVERING(4),
		DELIVERED(5),
		COMPLETED(6),
		CLOSED(7),
		CANCLED(8);
		private int value;  

	    private ProductOrderState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}
	@ManyToOne
	private CustomerOrder customerOrder;
	
	private ProductOrderItem() {
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
		return super.getId();
	}

	
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder=customerOrder;
		
	}

	
	public void setProductOrderId(long productOrderId) {
		super.setId(productOrderId);
		
	}

	
	public int getProductOrderState() {
		return this.getBiiState();
	}

	
	public void setProductOrderState(int productOrderState) {
		this.setBiiState(productOrderState);		
	}	
}
