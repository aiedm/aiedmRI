package com.ai.crm.customerorder.domain.model.interfaces;


public interface IOfferOrderItem extends ICustomerOrderItem{
	enum OfferOrderState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		CHARGE_ASSIGNED(9),
		COMPLETED(6),
		CLOSED(7),
		CANCLED(8);
		private int value;  

	    private OfferOrderState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}	
	ICustomerOrder getCustomerOrder();
	void setCustomerOrder(ICustomerOrder customerOrder);
	IOfferOrderItem getReplcedOfferOrderItem();
	void setReplcedOfferOrderItem(IOfferOrderItem offerOrderItem);
	int getOfferOrderState();
	void setOfferOrderState(int offerOrderState);	
	long getOfferOrderId();
	void setOfferOrderId(long offerOrderId);
}
