package com.ai.crm.product.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;

@MappedSuperclass
public abstract class Product extends SpecInstanceEntity{
	private long customerId;
	private long userId;
	private long productSpecificationId;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
