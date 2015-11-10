package com.ai.crm.customerorder.domain.model;

import org.springframework.stereotype.Component;

@Component
public class OfferOrderItem extends CustomerOrderItem{
	private CustomerOrder customerOrder;
	private OfferOrderItem replacedOfferOrderItem;
	private long offerOrderId;
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
		return this.offerOrderId;
	}

	
	public void setOfferOrderId(long offerOrderId) {
		this.offerOrderId=offerOrderId;
	}

}
