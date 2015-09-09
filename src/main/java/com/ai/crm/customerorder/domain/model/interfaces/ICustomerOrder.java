package com.ai.crm.customerorder.domain.model.interfaces;

import java.util.Set;

import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteraction;

public interface ICustomerOrder extends IBusinessInteraction{
	enum CustomerOrderState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		PAID(3),
		DELIVERING(4),
		DELIVERED(5),
		COMPLETED(6),
		CLOSED(7),
		CANCLED(8);
		private int value;  

	    private CustomerOrderState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}
	boolean isDirectSubmitOrder();
	void setDirectSubmitOrder(boolean directSubmitOrder);
	long getCustomerOrderId();
	void setCustomerOrderId(long customerOrderId);
	String getCustomerOrderCode();
	void setCustomerOrderCode(String customerOrderCode);
	Set<IProductOrder> getProductOrders();
	void addOfferOrder(IOfferOrder offerOrder);
	void addProductOffer(IProductOrder productOrder);
	Set<IOfferOrder> getOfferOrders();
	int getOrderState();
	void setOrderState(int orderState);
}
