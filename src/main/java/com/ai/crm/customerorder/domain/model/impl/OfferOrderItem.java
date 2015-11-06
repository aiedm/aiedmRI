package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
@Component
public class OfferOrderItem extends CustomerOrderItem implements IOfferOrderItem {
	private ICustomerOrder customerOrder;
	private IOfferOrderItem replacedOfferOrderItem;
	private long offerOrderId;
	protected OfferOrderItem() {
		
	}
	
	public OfferOrderItem(ICustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
		customerOrder.addOfferOrder(this);
	}	

	@Override
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	@Override
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder=customerOrder;		
	}


	@Override
	public int getOfferOrderState() {
		return this.getBiiState();
	}

	@Override
	public void setOfferOrderState(int offerOrderState) {
		this.setBiiState(offerOrderState);		
	}

	@Override
	public IOfferOrderItem getReplcedOfferOrderItem() {
		return replacedOfferOrderItem;
	}

	@Override
	public void setReplcedOfferOrderItem(IOfferOrderItem offerOrderItem) {
		replacedOfferOrderItem=offerOrderItem;
	}

	@Override
	public long getOfferOrderId() {
		return this.offerOrderId;
	}

	@Override
	public void setOfferOrderId(long offerOrderId) {
		this.offerOrderId=offerOrderId;
	}

}
