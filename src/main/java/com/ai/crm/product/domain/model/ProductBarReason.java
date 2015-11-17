package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
public class ProductBarReason extends InstanceEntity {
	@ManyToOne
	private Product product;
	private int barCode;
	@Id
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

	
	public Product getProduct() {
		return this.product;
	}

	
	public void setProduct(Product product) {
		this.product=product;
	}

}
