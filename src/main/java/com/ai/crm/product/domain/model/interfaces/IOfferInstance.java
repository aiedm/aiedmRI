package com.ai.crm.product.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;

public interface IOfferInstance extends ISpecificationInstanceEntity{
	enum OfferInstanceState {
		INITIATED(0),
		ACTIVE(1),
		LOCKED(2),
		INACTIVE(3),		
		UNSUBSCRIBED(4);
 
		private int value; 
	    private OfferInstanceState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}	
	Set<IProduct> getProducts();
	void addProduct(IProduct product);
	Set<IPricePlanInstance> getPricePlanInstances();
	void addPricePlanInstance(IPricePlanInstance pricePlanInstance);
	long getCustomerId();
	void setCustomerId(long customerId);
	long getProductOfferingId();
	void setProductOfferingId(long productOfferingId);
}
