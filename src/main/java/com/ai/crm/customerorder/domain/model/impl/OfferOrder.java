package com.ai.crm.customerorder.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.impl.BusinessInteractionItem;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteraction;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderCharacteristic;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
@Component
public class OfferOrder extends BusinessInteractionItem implements IOfferOrder {
	private long offerOrderId;
	private ICustomerOrder customerOrder;
	private Set<IProductOrder> productOrders=new HashSet<IProductOrder>();
	private IToBeOfferInstance toBeOfferInstance;
	
	private OfferOrder() {
		
	}
	
	public OfferOrder(ICustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
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
	public Set<IOfferOrderCharacteristic> getOfferOrderCharacteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOfferOrderCharacteristic(IOfferOrderCharacteristic offerOrderCharacteristic) {
		// TODO Auto-generated method stub
	}

	@Override
	public long getBusinessInteractionSpecificationId() {
		// TODO Auto-generated method stub
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

}
