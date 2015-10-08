package com.ai.crm.customerorder.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.interfaces.IInstanceEntity;
import com.ai.common.rootentity.interfaces.IInstanceEntityCharacteristic;
import com.ai.crm.customerorder.domain.model.impl.OrderPrice;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = OrderPrice.class, name = "PriceOrder")
	    })
public interface IOrderPrice extends IInstanceEntity{
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
	IProductOrderItem getProductOrder();
	void setProductOrder(IProductOrderItem productOrder);
	IOfferOrderItem getOfferOrder();
	void setOfferOrder(IOfferOrderItem offerOrder);
	Set<IInstanceEntityCharacteristic> getPriceCharacters();
	void addPriceCharacter(IInstanceEntityCharacteristic priceCharacteristic);
	long getRoleId();
	void setRoleId(long roleId);
}
