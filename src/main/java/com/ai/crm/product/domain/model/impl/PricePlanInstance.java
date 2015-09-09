package com.ai.crm.product.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstanceCharacteristic;
import com.ai.crm.product.domain.model.interfaces.IProduct;

public class PricePlanInstance implements IPricePlanInstance {
	private long pricePlanInstanceId;
	private IOfferInstance offerInstance;
	private Set<IProduct> assignedTo=new HashSet<IProduct>();
	private long pricePlanId;

	public PricePlanInstance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getPricePlanInstanceId() {
		return pricePlanInstanceId;
	}

	@Override
	public void setPricePlanInstanceId(long pricePlanInstanceId) {
		this.pricePlanInstanceId=pricePlanInstanceId;
	}

	@Override
	public Set<IPricePlanInstanceCharacteristic> getCharacteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCharacteristic(IPricePlanInstanceCharacteristic pricePlanInstanceCharacteristic) {
		// TODO Auto-generated method stub

	}

	@Override
	public IOfferInstance getOfferInstance() {
		return offerInstance;
	}

	@Override
	public void setOfferInstance(IOfferInstance offerInstance) {
		this.offerInstance=offerInstance;
	}

	@Override
	public Set<IProduct> getAssignedTo() {
		return assignedTo;
	}

	@Override
	public void assignTo(IProduct product) {
		if(null!=product){
			assignedTo.add(product);
			Set<IPricePlanInstance> assigndePrices=product.getAssignedPrices();
			if(!assigndePrices.contains(this)){
				product.assignPrice(this);
			}
		}
		
	}

	@Override
	public long getPricePlanId() {
		return pricePlanId;
	}

	@Override
	public void setPricePlanId(long pricePlanId) {
		this.pricePlanId=pricePlanId;
	}

}
