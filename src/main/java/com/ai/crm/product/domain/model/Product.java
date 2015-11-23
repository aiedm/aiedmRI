package com.ai.crm.product.domain.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;

@MappedSuperclass
public abstract class Product extends SpecInstanceEntity{
	private long customerId;
	private long userId;
	private long productSpecificationId;
	private String serialNumber;
		
	@Id
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	


	public Product() {
	}
	
	public long getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(long customerId) {
		this.customerId=customerId;		
	}

	
	public long getUserId() {
		return userId;
	}

	
	public void setUserId(long userId) {
		this.userId=userId;
	}

	
	public long getProductSpecificationId() {
		return productSpecificationId;
	}

	
	public void setProductSpecificationId(long productSpecificationId) {
		this.productSpecificationId=productSpecificationId;
	}

	
	public String getSerialNumber() {
		return this.serialNumber;
	}

	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber=serialNumber;
	}
}
