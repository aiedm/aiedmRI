package com.ai.crm.customerorder.domain.event.submitorder;

import java.util.Set;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.common.businessinteraction.domain.model.BIIRelatedEntity;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;


public abstract class OrderSubmitBaseEvent extends BaseEvent {
	private CustomerOrder customerOrder;
	//did not decompose to product order item
	private Set<OfferOrderItem> offerOrderItems;
	private Set<ToBeOfferInstance> toBeOfferInstances;
	public Set<OfferOrderItem> getOfferOrderItems() {
		return offerOrderItems;
	}
	public void addOfferOrderItem(OfferOrderItem offerOrderItem,ToBeOfferInstance toBeOfferInstance) {
		if(null!=offerOrderItem){			
			this.offerOrderItems.add(offerOrderItem);
			this.customerOrder.addOfferOrder(offerOrderItem);
			if (null!=toBeOfferInstance){
				BIIRelatedEntity relatedOfferInstance=new BIIRelatedEntity();
				relatedOfferInstance.setToBeInstanceEntity(toBeOfferInstance);
				offerOrderItem.setRelatedEntity(relatedOfferInstance);
			}
		}
	}
	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public Set<ToBeOfferInstance> getToBeOfferInstances() {
		return toBeOfferInstances;
	}
	public void addToBeOfferInstance(ToBeOfferInstance toBeOfferInstance,OfferOrderItem offerOrderItem) {
		if (null!=toBeOfferInstance){
			this.toBeOfferInstances.add(toBeOfferInstance);
			if(null!=offerOrderItem){
				BIIRelatedEntity relatedOfferInstance=new BIIRelatedEntity();
				relatedOfferInstance.setToBeInstanceEntity(toBeOfferInstance);
				offerOrderItem.setRelatedEntity(relatedOfferInstance);
			}
		}
		
	}	
	public OrderSubmitBaseEvent(Object source) {
		super(source);
	}

}
