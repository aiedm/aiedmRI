package com.ai.crm.customerorder.application.service.api.dto;

public class ShoppingCartDTO extends CustomerOrderDTO {
	public ShoppingCartDTO() {
		
	}

	public long getShoppingCartId(){
		return this.getCustomerOrderId();
	}
	
}
