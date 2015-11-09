package com.ai.crm.product.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;

public interface IPricePlanInstance extends ISpecificationInstanceEntity{
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
	IOfferInstance getOfferInstance();
	void setOfferInstance(IOfferInstance offerInstance);
	Set<IProductPriceRel> getAssignedTo();
	void assignTo(IProductPriceRel productPriceRel);
	long getPricePlanId();
	void setPricePlanId(long pricePlanId);
	long getPriceValue();
	void setPriceValue(long priceValue);
	int getPayState();
	void unPaid();
	void paid();
	String getDiscountReason();
	void setDiscountReason(String discountReason);
	long getRoleId();
	void setRoleId(long roleId);	
}
