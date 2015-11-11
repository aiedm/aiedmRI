package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.SpecificationInstanceEntity;
@Component
public class PricePlanInstance extends SpecificationInstanceEntity {
	public enum PriceState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		PAID(3),
		ASSIGNED(5),
		COMPLETED(6);
		private int value;  

	    private PriceState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}		
	private OfferInstance offerInstance;
	private Set<ProductPriceRel> assignedTo=new LinkedHashSet<ProductPriceRel>();
	private long pricePlanId;
	private long priceValue;
	private int payState;
	private String discountReason;
	private long roleId;

	public PricePlanInstance() {
	}

	
	public OfferInstance getOfferInstance() {
		return offerInstance;
	}

	
	public void setOfferInstance(OfferInstance offerInstance) {
		this.offerInstance=offerInstance;
	}

	
	public Set<ProductPriceRel> getAssignedTo() {
		return assignedTo;
	}

	
	public void assignTo(ProductPriceRel productPriceRel) {
		if(null!=productPriceRel){
			assignedTo.add(productPriceRel);
			if(null==productPriceRel.getPricePlanInstance()){
				productPriceRel.setPricePlanInstance(this);
			}
		}
		
	}

	
	public long getPricePlanId() {
		return pricePlanId;
	}

	
	public void setPricePlanId(long pricePlanId) {
		this.pricePlanId=pricePlanId;
	}
	
	
	public long getPriceValue() {
		return this.priceValue;
	}

	
	public void setPriceValue(long priceValue) {
		this.priceValue=priceValue;
	}	

	
	public int getPayState() {
		return this.payState;
	}

	
	public void unPaid() {
		this.payState=PricePlanInstance.PriceState.SUBMITTED.getValue();
	}

	
	public void paid() {
		this.payState=PricePlanInstance.PriceState.PAID.getValue();
	}

	
	public String getDiscountReason() {
		return this.discountReason;
	}

	
	public void setDiscountReason(String discountReason) {
		this.discountReason=discountReason;
	}
	
	public long getRoleId() {
		return this.roleId;
	}

	
	public void setRoleId(long roleId) {
		this.roleId=roleId;
	}
}
