package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class CustomerOrderDTO {
	private long customerId;
	private long customerOrderId;
	private String customerOrderCode;
	private long businessInteractionSpecId;
	private long shoppingCartId;
	private Set<OfferOrderItemDTO>  offerOrderItems=new LinkedHashSet<OfferOrderItemDTO>();
	private Set<ProductOrderItemDTO>  productOrderItems=new LinkedHashSet<ProductOrderItemDTO>();
	private Set<CharacterInstanceDTO>  customerOrderCharacters=new LinkedHashSet<CharacterInstanceDTO>();
	private int action=1;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}	
	
	public long getCustomerOrderId() {
		return customerOrderId;
	}


	public void setCustomerOrderId(long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}



	public long getBusinessInteractionSpecId() {
		return businessInteractionSpecId;
	}



	public void setBusinessInteractionSpecId(long businessInteractionSpecId) {
		this.businessInteractionSpecId = businessInteractionSpecId;
	}



	public long getShoppingCartId() {
		return shoppingCartId;
	}



	public void setShoppingCartId(long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public Set<OfferOrderItemDTO>  getOfferOrderItems(){
		return this.offerOrderItems;
	}

	public void addOfferOrderItem(OfferOrderItemDTO offerOrderItemDTO){
		if(null!=offerOrderItemDTO){
			this.offerOrderItems.add(offerOrderItemDTO);
		}
	}
	
	public Set<CharacterInstanceDTO>  getCustomerOrderCharacters(){
		return this.customerOrderCharacters;
	}
	
	public void addCustomerOrderCharacter(CharacterInstanceDTO characteristicInstanceDTO){
		if (null!=characteristicInstanceDTO){
			customerOrderCharacters.add(characteristicInstanceDTO);
		}
	}
	
	public CustomerOrderDTO() {
	}


	public Set<ProductOrderItemDTO> getProductOrderItems() {
		return productOrderItems;
	}


	public void addProductOrderItem(ProductOrderItemDTO productOrderItem) {
		if(null!=productOrderItem){
			this.productOrderItems.add(productOrderItem);
		}
		
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerOrderCode() {
		return customerOrderCode;
	}


	public void setCustomerOrderCode(String customerOrderCode) {
		this.customerOrderCode = customerOrderCode;
	}

}
