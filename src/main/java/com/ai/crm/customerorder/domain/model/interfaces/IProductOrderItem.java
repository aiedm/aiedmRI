package com.ai.crm.customerorder.domain.model.interfaces;


public interface IProductOrderItem extends ICustomerOrderItem{
	enum ProductOrderState {
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
	ICustomerOrder getCustomerOrder();
	void setCustomerOrder(ICustomerOrder customerOrder);
	long getProductOrderId();
	void setProductOrderId(long productOrderId);
	long getBusinessInteractionSpecificationId();
	int getProductOrderState();
	void setProductOrderState(int productOrderState);	
}
