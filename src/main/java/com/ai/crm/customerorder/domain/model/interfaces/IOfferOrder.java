package com.ai.crm.customerorder.domain.model.interfaces;

import java.util.Set;

import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;
import com.ai.crm.customerorder.domain.model.impl.OfferOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = OfferOrder.class, name = "OfferOrder")
	    })
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
	Set<IOfferOrderCharacteristicValue> getOfferOrderCharacteristics();
	void addOfferOrderCharacteristic(IOfferOrderCharacteristicValue offerOrderCharacteristic);
	long getBusinessInteractionSpecificationId();
	long getOldOfferInstanceId();
	int getOfferOrderState();
	void setOfferOrderState(int offerOrderState);	
	IToBeOfferInstance getToBeOfferInstance();
	void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance);
	Set<IOrderPrice> getPrices();
	void addPrice(IOrderPrice orderPrice);
}
