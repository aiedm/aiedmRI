package com.ai.crm.customerorder.domain.model.interfaces;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
		@Type(value = IShoppingCart.class, name = "ShoppingCart")
	    })
public interface IShoppingCart extends ICustomerOrder {

}
