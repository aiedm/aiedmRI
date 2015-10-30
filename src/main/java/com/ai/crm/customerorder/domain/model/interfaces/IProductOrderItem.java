package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.customerorder.domain.model.impl.ProductOrderItem;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = ProductOrderItem.class, name = "ProductOrder"),
	    })
public interface IProductOrderItem extends ICustomerOrderItem{
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
	IOfferOrderItem getOfferOrder();
	void setOfferOrder(IOfferOrderItem offerOrder);
	long getProductOrderId();
	void setProductOrderId(long productOrderId);
	long getBusinessInteractionSpecificationId();
	int getProductOrderState();
	void setProductOrderState(int productOrderState);	
	IToBeProduct getToBeProduct();
	void setToBeProduct(IToBeProduct toBeProduct);
}
