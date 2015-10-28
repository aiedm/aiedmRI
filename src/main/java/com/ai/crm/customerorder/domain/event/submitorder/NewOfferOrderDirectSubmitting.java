package com.ai.crm.customerorder.domain.event.submitorder;

import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;

public class NewOfferOrderDirectSubmitting extends BaseEvent {
	private ICustomerOrder customerOrder;
	//did not decompose to product order item
	private Set<IOfferOrderItem> offerOrderItems;
	private Set<IToBeOfferInstance> toBeOfferInstances;
	public Set<IOfferOrderItem> getOfferOrderItems() {
		return offerOrderItems;
	}
	public void addOfferOrderItem(IOfferOrderItem offerOrderItem,IToBeOfferInstance toBeOfferInstance) {
		if(null!=offerOrderItem){			
			this.offerOrderItems.add(offerOrderItem);
			this.customerOrder.addOfferOrder(offerOrderItem);
			if (null!=toBeOfferInstance){
				offerOrderItem.setToBeOfferInstance(toBeOfferInstance);
			}
		}
	}
	
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public Set<IToBeOfferInstance> getToBeOfferInstances() {
		return toBeOfferInstances;
	}
	public void addToBeOfferInstance(IToBeOfferInstance toBeOfferInstance,IOfferOrderItem offerOrderItem) {
		if (null!=toBeOfferInstance){
			this.toBeOfferInstances.add(toBeOfferInstance);
			if(null!=offerOrderItem){
				offerOrderItem.setToBeOfferInstance(toBeOfferInstance);
			}
		}
		
	}	
	public NewOfferOrderDirectSubmitting(Object source) {
		super(source);
	}

}
