package com.ai.crm.product.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IProduct extends IInstanceEntity{
	enum ProductState {
		INITIATED(0),
		PREACTIVE(1),
		ACTIVE(2),
		SUSPEND(3),
		INACTIVE(4),	
		TERMINATE(5),
		LOCKED(6),
		UNSUBSCRIBED(7);
				
		private int value; 
	    private ProductState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}
	long getProductId();
	void setProductId(long productId);
	Set<IProductBarReason> getBarReasons();
	void addBarReason(IProductBarReason productBarReason);
	Set<IOfferInstance> getParticipantOfferInstances();
	void addToOfferInstance(IOfferInstance offerInstance);
	Set<IPricePlanInstance> getAssignedPrices();
	void assignPrice(IPricePlanInstance pricePlanInstance);
	long getCustomerId();
	void setCustomerId(long customerId);
	long getUserId();
	void setUserId(long userId);
	long getProductSpecificationId();
	void setProductSpecificationId(long productSpecificationId);
	String getSerialNumber();
	void setSerialNumber(String serialNumber);
}
