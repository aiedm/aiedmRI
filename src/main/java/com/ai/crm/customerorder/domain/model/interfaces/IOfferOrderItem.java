package com.ai.crm.customerorder.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.interfaces.IInstanceEntityCharacteristic;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;
import com.ai.crm.customerorder.domain.model.impl.OfferOrderItem;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = OfferOrderItem.class, name = "OfferOrder")
	    })
public interface IOfferOrderItem extends IBusinessInteractionItem{
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
	Set<IProductOrderItem> getProductOrders();
	void addProductOrder(IProductOrderItem productOrder);
	Set<IInstanceEntityCharacteristic> getOfferOrderCharacteristics();
	void addOfferOrderCharacteristic(IInstanceEntityCharacteristic offerOrderCharacteristic);
	long getOldOfferInstanceId();
	int getOfferOrderState();
	void setOfferOrderState(int offerOrderState);	
	IToBeOfferInstance getToBeOfferInstance();
	void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance);
	Set<IOrderPrice> getPrices();
	void addPrice(IOrderPrice orderPrice);
}
