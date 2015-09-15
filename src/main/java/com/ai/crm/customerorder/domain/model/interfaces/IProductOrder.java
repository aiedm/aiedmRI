package com.ai.crm.customerorder.domain.model.interfaces;

import java.util.Set;

import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;

public interface IProductOrder extends IBusinessInteractionItem{
	enum ProductOrderState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		DELIVERING(4),
		DELIVERED(5),
		COMPLETED(6),
		CLOSED(7),
		CANCLED(8);
		private int value;  

	    private ProductOrderState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}	
	ICustomerOrder getCustomerOrder();
	void setCustomerOrder(ICustomerOrder customerOrder);
	IOfferOrder getOfferOrder();
	void setOfferOrder(IOfferOrder offerOrder);
	long getProductOrderId();
	void setProductOrderId(long productOrderId);
	Set<IProductOrderCharacteristicValue> getProductOrderCharacteristics();
	void addProductOrderCharacteristic(IProductOrderCharacteristicValue productOrderCharacteristic);
	long getBusinessInteractionSpecificationId();
	int getProductOrderState();
	void setProductOrderState(int productOrderState);	
	IToBeProduct getToBeProduct();
	void setToBeProduct(IToBeProduct toBeProduct);
	long getProductSpecificationId();
	void setProductSpecificationId(long productSpecificationId);
	Set<IOrderPrice> getPrices();
	void addPrice(IOrderPrice orderPrice);	
}
