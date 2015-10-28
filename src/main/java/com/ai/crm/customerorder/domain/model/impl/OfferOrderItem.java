package com.ai.crm.customerorder.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class OfferOrderItem extends CustomerOrderItem implements IOfferOrderItem {
	private long offerOrderId;
	@JsonIgnore
	private ICustomerOrder customerOrder;
	private Set<IProductOrderItem> productOrders=new HashSet<IProductOrderItem>();
	private IToBeOfferInstance toBeOfferInstance;
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
	public long getOfferOrderId() {
		return this.offerOrderId;
	}

	@Override
	public Set<IProductOrderItem> getProductOrders() {
		return productOrders;
	}

	@Override
	public void addProductOrder(IProductOrderItem productOrder) {
		productOrders.add(productOrder);
		productOrder.setOfferOrder(this);
	}

	@Override
	public long getOldOfferInstanceId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder=customerOrder;		
	}

	@Override
	public void setOfferOrderId(long offerOrderId) {
		this.offerOrderId=offerOrderId;
		
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
	public IToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}

	@Override
	public void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance=toBeOfferInstance;
	}

}
