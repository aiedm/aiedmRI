package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.customerorder.domain.model.impl.ProductOrderItem;
import com.ai.crm.product.domain.model.interfaces.IProduct;
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
public interface IToBeProduct extends IProduct {
	IProductOrderItem getProductOrder();
	void setProductOrder(IProductOrderItem productOrder);
}
