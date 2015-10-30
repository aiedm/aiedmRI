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
	@JsonIgnore
	private ICustomerOrder customerOrder;
	private Set<IProductOrderItem> relatedProductOrders=new HashSet<IProductOrderItem>();
	private IToBeOfferInstance toBeOfferInstance;
	private IOfferOrderItem replacedOfferOrderItem;
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
	public Set<IProductOrderItem> getRelatedProductOrders() {
		return relatedProductOrders;
	}

	@Override
	public void addRelatedProductOrder(IProductOrderItem productOrder) {
		relatedProductOrders.add(productOrder);
		productOrder.setOfferOrder(this);
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
	public IToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}

	@Override
	public void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance=toBeOfferInstance;
	}

	@Override
	public IOfferOrderItem getReplcedOfferOrderItem() {
		return replacedOfferOrderItem;
	}

	@Override
	public void setReplcedOfferOrderItem(IOfferOrderItem offerOrderItem) {
		replacedOfferOrderItem=offerOrderItem;
	}

}
