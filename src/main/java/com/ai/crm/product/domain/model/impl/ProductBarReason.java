package com.ai.crm.product.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.impl.InstanceEntity;
import com.ai.crm.product.domain.model.interfaces.IProduct;
import com.ai.crm.product.domain.model.interfaces.IProductBarReason;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ProductBarReason extends InstanceEntity implements IProductBarReason {
	@JsonIgnore
	private IProduct product;
	private int barCode;
	public ProductBarReason() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBarCode() {
		return this.barCode;
	}

	@Override
	public void setBarCode(int barCode) {
		this.barCode=barCode;
	}

	@Override
	public IProduct getProduct() {
		return this.product;
	}

	@Override
	public void setProduct(IProduct product) {
		this.product=product;
	}

}
