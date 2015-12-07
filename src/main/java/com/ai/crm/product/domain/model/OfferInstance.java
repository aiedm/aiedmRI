package com.ai.crm.product.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
@MappedSuperclass
public class OfferInstance extends SpecInstanceEntity{

	private long customerId;
	private long productOfferingId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public OfferInstance() {
	}
	
	public long getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(long customerId) {
		this.customerId=customerId;
	}

	
	public long getProductOfferingId() {
		return productOfferingId;
	}

	
	public void setProductOfferingId(long productOfferingId) {
		this.productOfferingId=productOfferingId;
	}

}
