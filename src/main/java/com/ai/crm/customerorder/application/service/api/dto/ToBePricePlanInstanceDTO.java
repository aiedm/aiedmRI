package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.common.basetype.TimePeriod;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = ToBePricePlanInstanceDTO.class, name = "ToBePricePlanInstanceDTO")
})
public class ToBePricePlanInstanceDTO {
	private long pricePlanId;
	private long pricePlanInstanceId;
	private long inputedValue;
	private String discountReason;
	private int roleId;
	private int action;
	private TimePeriod validPeriod;
	private Set<CharacterInstanceDTO> pricePlanInstanceCharacteristics = new LinkedHashSet<CharacterInstanceDTO>();
	private Set<ToBePricePlanInstanceProductDTO> appliedToProducts=new LinkedHashSet<ToBePricePlanInstanceProductDTO>();

	
	public Set<ToBePricePlanInstanceProductDTO> getAppliedToProducts(){
		return this.appliedToProducts;
	}
	
	public void applyToProduct(ToBeProductDTO toBeProductDTO,TimePeriod validPeriod){
		if(null!=toBeProductDTO){
			ToBePricePlanInstanceProductDTO productRel=new ToBePricePlanInstanceProductDTO();
			productRel.setToBePricePlanInstanceDTO(this);
			productRel.setToBeProductDTO(toBeProductDTO);
			productRel.setValidPeriod(validPeriod);
			this.appliedToProducts.add(productRel);
		}
	}
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
	
	public long getPricePlanId() {
		return pricePlanId;
	}


	public void setPricePlanId(long pricePlanId) {
		this.pricePlanId = pricePlanId;
	}


	public long getPricePlanInstanceId() {
		return pricePlanInstanceId;
	}


	public void setPricePlanInstanceId(long pricePlanInstanceId) {
		this.pricePlanInstanceId = pricePlanInstanceId;
	}

	public long getInputedValue() {
		return inputedValue;
	}


	public void setInputedValue(long inputedValue) {
		this.inputedValue = inputedValue;
	}


	public String getDiscountReason() {
		return discountReason;
	}


	public void setDiscountReason(String discountReason) {
		this.discountReason = discountReason;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public Set<CharacterInstanceDTO> getPricePlanInstanceCharacteristics() {
		return pricePlanInstanceCharacteristics;
	}


	public void addPricePlanInstanceCharacteristics(CharacterInstanceDTO pricePlanInstanceCharacteristic) {
		if(null!=pricePlanInstanceCharacteristic){
			this.pricePlanInstanceCharacteristics.add(pricePlanInstanceCharacteristic);
		}
		
	}


	public ToBePricePlanInstanceDTO() {
		
	}


	public TimePeriod getValidPeriod() {
		return validPeriod;
	}


	public void setValidPeriod(TimePeriod validPeriod) {
		this.validPeriod = validPeriod;
	}

}
