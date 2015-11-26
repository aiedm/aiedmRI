package com.ai.crm.product.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@MappedSuperclass
public abstract class ProductPriceRel extends InstanceEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
	public ProductPriceRel() {
	}

}
