package com.ai.crm.customerorder.domain.model.interfaces;

import java.util.Set;

public interface IOrderPrice {
	enum PriceState {
		UNPAID(0),
		PAID(1);
				
		private int value; 
	    private PriceState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}
	long getPricePlanId();
	void setPricePlanId(long pricePlanId);
	long getPriceValue();
	void setPriceValue(long priceValue);
	int getPayState();
	void unPaid();
	void paid();
	String getDiscountReason();
	void setDiscountReason(String discountReason);
	long getPricePlanInstanceId();
	void setPricePlanbInstanceId(long pricePlanInstanceId);
	IProductOrder getProductOrder();
	void setProductOrder(IProductOrder productOrder);
	IOfferOrder getOfferOrder();
	void setOfferOrder(IOfferOrder offerOrder);
	Set<IOrderPriceCharacteristicValue> getPriceCharacterValues();
	void addPriceCharacterValue(IOrderPriceCharacteristicValue priceCharacteristicValue);
}
