package com.ai.crm.customerorder.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.impl.BusinessInteraction;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
@Component
public class CustomerOrder extends BusinessInteraction implements ICustomerOrder {
	private long customerOrderId;
	private String customerOrderCode;
	private boolean directSubmitOrder;
	private Set<IOfferOrder> offerOrders=new HashSet<IOfferOrder>();
	private Set<IProductOrder> productOrders=new HashSet<IProductOrder>();
	
	public CustomerOrder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDirectSubmitOrder() {
		return directSubmitOrder;
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
	public Set<IProductOrder> getProductOrders() {
		return productOrders;
	}

	@Override
	public Set<IOfferOrder> getOfferOrders() {
		return offerOrders;
	}

	@Override
	public void addOfferOrder(IOfferOrder offerOrder) {
		if (null!=offerOrder){
			offerOrders.add(offerOrder);
			offerOrder.setCustomerOrder(this);
		}
	}

	@Override
	public void addProductOffer(IProductOrder productOrder) {
		if (null!=productOrder){
			productOrders.add(productOrder);
			productOrder.setCustomerOrder(this);
		}
	}

	@Override
	public void setDirectSubmitOrder(boolean directSubmitOrder) {
		this.directSubmitOrder=directSubmitOrder;
		
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

}
