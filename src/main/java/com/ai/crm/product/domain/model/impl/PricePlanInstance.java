package com.ai.crm.product.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.impl.SpecificationInstanceEntity;
import com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IProductPriceRel;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class PricePlanInstance extends SpecificationInstanceEntity implements IPricePlanInstance {
	@JsonIgnore
	private IOfferInstance offerInstance;
	private Set<IProductPriceRel> assignedTo=new HashSet<IProductPriceRel>();
	private long pricePlanId;
	private long priceValue;
	private int payState;
	private String discountReason;
	private long roleId;

	public PricePlanInstance() {
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
	public Set<IProductPriceRel> getAssignedTo() {
		return assignedTo;
	}

	@Override
	public void assignTo(IProductPriceRel productPriceRel) {
		if(null!=productPriceRel){
			assignedTo.add(productPriceRel);
			if(null==productPriceRel.getPricePlanInstance()){
				productPriceRel.setPricePlanInstance(this);
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
