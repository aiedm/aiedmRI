package com.ai.crm.product.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@MappedSuperclass
public abstract class ProductBarReason extends InstanceEntity {
	private int barCode;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public ProductBarReason() {
	}

	
	public int getBarCode() {
		return this.barCode;
	}

	
	public void setBarCode(int barCode) {
		this.barCode=barCode;
	}
}
