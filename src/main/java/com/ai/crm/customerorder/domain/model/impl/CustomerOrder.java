package com.ai.crm.customerorder.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.impl.BusinessInteraction;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
@Component
public class CustomerOrder extends BusinessInteraction implements ICustomerOrder {
	private long customerOrderId;
	private String customerOrderCode;
	private Set<IOfferOrderItem> offerOrders=new HashSet<IOfferOrderItem>();
	private Set<IProductOrderItem> productOrders=new HashSet<IProductOrderItem>();
	private long shoppingCartId;
	public CustomerOrder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getCustomerOrderId() {
		return customerOrderId;
	}

	@Override
	public String getCustomerOrderCode() {
		return customerOrderCode;
	}

	@Override
	public Set<IProductOrderItem> getProductOrders() {
		return productOrders;
	}

	@Override
	public Set<IOfferOrderItem> getOfferOrders() {
		return offerOrders;
	}

	@Override
	public void addOfferOrder(IOfferOrderItem offerOrder) {
		if (null!=offerOrder){
			offerOrders.add(offerOrder);
			if(null==offerOrder.getCustomerOrder()){
				offerOrder.setCustomerOrder(this);
			}			
		}
	}

	@Override
	public void addProductOrder(IProductOrderItem productOrder) {
		if (null!=productOrder){
			productOrders.add(productOrder);
			if(null==productOrder.getCustomerOrder()){
				productOrder.setCustomerOrder(this);
			}
			
		}
	}

	@Override
	public void setCustomerOrderId(long customerOrderId) {
		this.customerOrderId=customerOrderId;
		
	}

	@Override
	public void setCustomerOrderCode(String customerOrderCode) {
		this.customerOrderCode=customerOrderCode;
		
	}
	
	public int getOrderState(){
		return this.getBiState();
	}
	
	public void setOrderState(int orderState){
		this.setBiState(orderState);
	}

	@Override
	public long getShoppingCartId() {
		return this.shoppingCartId;
	}

	@Override
	public void setShoppingCartId(long shoppingCartId) {
		this.shoppingCartId=shoppingCartId;
	}

}
