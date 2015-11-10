package com.ai.crm.customerorder.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.BusinessInteraction;
@Component
@Entity
@DiscriminatorValue("1000")
public class CustomerOrder extends BusinessInteraction {
	private Set<OfferOrderItem> offerOrders=new HashSet<OfferOrderItem>();
	private Set<ProductOrderItem> productOrders=new HashSet<ProductOrderItem>();
	private long shoppingCartId;
	public CustomerOrder( long biSpecId) {
		super(biSpecId);
	}

	
	public long getCustomerOrderId() {
		return this.getBusinessInteractionId();
	}

	
	public String getCustomerOrderCode() {
		return this.getCode();
	}

	
	public Set<ProductOrderItem> getProductOrders() {
		return productOrders;
	}

	
	public Set<OfferOrderItem> getOfferOrders() {
		return offerOrders;
	}

	
	public void addOfferOrder(OfferOrderItem offerOrder) {
		if (null!=offerOrder){
			offerOrders.add(offerOrder);
			if(null==offerOrder.getCustomerOrder()){
				offerOrder.setCustomerOrder(this);
			}			
		}
	}

	
	public void addProductOrder(ProductOrderItem productOrder) {
		if (null!=productOrder){
			productOrders.add(productOrder);
			if(null==productOrder.getCustomerOrder()){
				productOrder.setCustomerOrder(this);
			}
			
		}
	}

	
	public void setCustomerOrderId(long customerOrderId) {
		this.setBusinessInteractionId(customerOrderId);
		
	}

	
	public void setCustomerOrderCode(String customerOrderCode) {
		this.setCode(customerOrderCode);
		
	}
	
	public int getOrderState(){
		return this.getBiState();
	}
	
	public void setOrderState(int orderState){
		this.setBiState(orderState);
	}

	
	public long getShoppingCartId() {
		return this.shoppingCartId;
	}

	
	public void setShoppingCartId(long shoppingCartId) {
		this.shoppingCartId=shoppingCartId;
	}

}
