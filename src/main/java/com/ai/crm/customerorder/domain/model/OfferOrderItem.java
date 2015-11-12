package com.ai.crm.customerorder.domain.model;

public class OfferOrderItem extends CustomerOrderItem{
	public enum OfferOrderState {
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
	private CustomerOrder customerOrder;
	private OfferOrderItem replacedOfferOrderItem;
	protected OfferOrderItem() {
		
	}
	
	public OfferOrderItem(CustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
		customerOrder.addOfferOrder(this);
	}	

	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder=customerOrder;		
	}


	
	public int getOfferOrderState() {
		return this.getBiiState();
	}

	
	public void setOfferOrderState(int offerOrderState) {
		this.setBiiState(offerOrderState);		
	}

	
	public OfferOrderItem getReplcedOfferOrderItem() {
		return replacedOfferOrderItem;
	}

	
	public void setReplcedOfferOrderItem(OfferOrderItem offerOrderItem) {
		replacedOfferOrderItem=offerOrderItem;
	}

	
	public long getOfferOrderId() {
		return super.getId();
	}

	
	public void setOfferOrderId(long offerOrderId) {
		super.setId(offerOrderId);
	}

}
