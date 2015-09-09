package com.ai.crm.customerorder.domain.model.interfaces;

import java.util.Set;

import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;

public interface IOfferOrder extends IBusinessInteractionItem{
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
	long getOfferOrderId();
	void setOfferOrderId(long offerOrderId);
	Set<IProductOrder> getProductOrders();
	void addProductOrder(IProductOrder productOrder);
	Set<IOfferOrderCharacteristic> getOfferOrderCharacteristics();
	void addOfferOrderCharacteristic(IOfferOrderCharacteristic offerOrderCharacteristic);
	long getBusinessInteractionSpecificationId();
	long getOldOfferInstanceId();
	int getOfferOrderState();
	void setOfferOrderState(int offerOrderState);	
	IToBeOfferInstance getToBeOfferInstance();
	void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance);
}
