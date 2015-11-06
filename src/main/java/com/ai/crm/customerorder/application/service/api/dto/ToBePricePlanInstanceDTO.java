package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class ToBePricePlanInstanceDTO {
	private long pricePlanId;
	private long pricePlanInstanceId;
	private long inputedValue;
	private String discountReason;
	private int roleId;
	private int tempSeqId;
	private int action;
		
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
	private Set<CharacterInstanceDTO> pricePlanInstanceCharacteristics = new LinkedHashSet<CharacterInstanceDTO>();
	
	public int getTempSeqId() {
		return tempSeqId;
	}


	public void setTempSeqId(int tempSeqId) {
		this.tempSeqId = tempSeqId;
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

}
