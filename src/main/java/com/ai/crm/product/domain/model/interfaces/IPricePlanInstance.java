package com.ai.crm.product.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;
import com.ai.crm.product.domain.model.impl.PricePlanInstance;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
		@Type(value = PricePlanInstance.class, name = "PricePlanInstance")
	    })
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
	long getPricePlanInstanceId();
	void setPricePlanInstanceId(long pricePlanInstanceId);
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
