package com.ai.crm.product.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;

@MappedSuperclass
public abstract class Subscriber extends SpecInstanceEntity{
	private long customerId;
	private long productLineId;
	private String accessNumber;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	


	public Subscriber() {
	}
	
	public long getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(long customerId) {
		this.customerId=customerId;		
	}

	
	public long getProductLineId() {
		return productLineId;
	}

	
	public void setProductLineId(long productLineId) {
		this.productLineId=productLineId;
	}

	
	public String getAccessNumber() {
		return this.accessNumber;
	}

	
	public void setAccessNumber(String serialNumber) {
		this.accessNumber=serialNumber;
	}
}
