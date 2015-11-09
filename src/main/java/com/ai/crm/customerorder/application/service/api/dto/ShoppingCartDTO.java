package com.ai.crm.customerorder.application.service.api.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = ShoppingCartDTO.class, name = "ShoppingCartDTO")
})
public class ShoppingCartDTO extends CustomerOrderDTO {
	public ShoppingCartDTO() {
		
	}

	public long getShoppingCartId(){
		return this.getCustomerOrderId();
	}
	
}
