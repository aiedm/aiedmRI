package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = ToBeProductDTO.class, name = "ToBeProductDTO")
})
public class ToBeProductDTO {
	private long productSpecId;
	private long productId;
	private String name;
	private long customerId;
	private long subscriberId;
	private String serialNo;
	private int roleId;
	private Set<Long> assignedPriceTempSeqs=new LinkedHashSet<Long>();
	private Set<CharacterInstanceDTO> productCharacteristics = new LinkedHashSet<CharacterInstanceDTO>();
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Set<Long> getAssignedPriceTempSeqs() {
		return assignedPriceTempSeqs;
	}

	public void addAssignedPriceTempSeq(long assignedPriceTempSeq) {
		if(assignedPriceTempSeq>=0){
			this.assignedPriceTempSeqs.add(assignedPriceTempSeq);
		}		
	}

	public Set<CharacterInstanceDTO> getProductCharacteristics() {
		return productCharacteristics;
	}

	public void addProductCharacteristics(CharacterInstanceDTO productCharacteristic) {
		if(null!=productCharacteristic){
			this.productCharacteristics.add(productCharacteristic) ;
		}		
	}	
	
	public long getProductSpecId() {
		return productSpecId;
	}

	public void setProductSpecId(long productSpecId) {
		this.productSpecId = productSpecId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(long subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public ToBeProductDTO() {
		
	}

}
