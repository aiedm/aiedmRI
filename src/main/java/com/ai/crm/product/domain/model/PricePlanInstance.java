package com.ai.crm.product.domain.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class PricePlanInstance extends SpecInstanceEntity {
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

	private long pricePlanId;
	private long priceValue;
	private int payState;
	private String discountReason;
	private long roleId;
	@Column(name="PRICE_TYPE")
	private int priceType;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public PricePlanInstance() {
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

	public int getPriceType() {
		return priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}
}
