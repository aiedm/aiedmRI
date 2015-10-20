package com.ai.crm.product.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.SpecificationInstanceEntity;
import com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IProduct;

public class PricePlanInstance extends SpecificationInstanceEntity implements IPricePlanInstance {
	private long pricePlanInstanceId;
	private IOfferInstance offerInstance;
	private Set<IProduct> assignedTo=new HashSet<IProduct>();
	private long pricePlanId;
	private long priceValue;
	private int payState;
	private String discountReason;
	private long roleId;

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
	
	@Override
	public long getPriceValue() {
		return this.priceValue;
	}

	@Override
	public void setPriceValue(long priceValue) {
		this.priceValue=priceValue;
	}	

	@Override
	public int getPayState() {
		return this.payState;
	}

	@Override
	public void unPaid() {
		this.payState=IToBePricePlanInstance.PriceState.UNPAID.getValue();
	}

	@Override
	public void paid() {
		this.payState=IToBePricePlanInstance.PriceState.PAID.getValue();
	}

	@Override
	public String getDiscountReason() {
		// TODO Auto-generated method stub
		return this.discountReason;
	}

	@Override
	public void setDiscountReason(String discountReason) {
		this.discountReason=discountReason;
	}
	@Override
	public long getRoleId() {
		return this.roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		this.roleId=roleId;
	}
}
