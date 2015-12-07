package com.ai.crm.product.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@MappedSuperclass
public abstract class OfferInstanceProductRel extends InstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	public OfferInstanceProductRel() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
