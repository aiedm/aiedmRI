package com.ai.crm.customerorder.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.impl.BusinessInteractionItem;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderCharacteristicValue;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPrice;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
public class OfferOrder extends BusinessInteractionItem implements IOfferOrder {
	private long offerOrderId;
	@JsonIgnore
	private ICustomerOrder customerOrder;
	private Set<IProductOrder> productOrders=new HashSet<IProductOrder>();
	private IToBeOfferInstance toBeOfferInstance;
	private Set<IOrderPrice> prices=new HashSet<IOrderPrice>();
	protected OfferOrder() {
		
	}
	
	public OfferOrder(ICustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
		customerOrder.addOfferOrder(this);
	}	

	@Override
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	@Override
	public long getOfferOrderId() {
		return this.offerOrderId;
	}

	@Override
	public Set<IProductOrder> getProductOrders() {
		return productOrders;
	}

	@Override
	public void addProductOrder(IProductOrder productOrder) {
		productOrders.add(productOrder);
		productOrder.setOfferOrder(this);
	}

	@Override
	public Set<IOfferOrderCharacteristicValue> getOfferOrderCharacteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOfferOrderCharacteristic(IOfferOrderCharacteristicValue offerOrderCharacteristic) {
		// TODO Auto-generated method stub
	}

	@Override
	public long getBusinessInteractionSpecificationId() {
		//TODO
		return 0;
	}

	@Override
	public long getOldOfferInstanceId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder=customerOrder;		
	}

	@Override
	public void setOfferOrderId(long offerOrderId) {
		this.offerOrderId=offerOrderId;
		
	}

	@Override
	public int getOfferOrderState() {
		return this.getBiiState();
	}

	@Override
	public void setOfferOrderState(int offerOrderState) {
		this.setBiiState(offerOrderState);		
	}

	@Override
	public IToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}

	@Override
	public void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance=toBeOfferInstance;
	}

	@Override
	public Set<IOrderPrice> getPrices() {
		return this.prices;
	}

	@Override
	public void addPrice(IOrderPrice orderPrice) {
		if(null!=orderPrice){
			prices.add(orderPrice);
			if (null==orderPrice.getOfferOrder()){
				orderPrice.setOfferOrder(this);
			}
		}
		
	}

}
