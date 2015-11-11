package com.ai.crm.customerorder.domain.model;

import org.springframework.stereotype.Component;
@Component
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
