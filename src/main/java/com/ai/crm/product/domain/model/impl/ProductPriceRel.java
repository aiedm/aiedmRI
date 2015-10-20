package com.ai.crm.product.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.impl.InstanceEntity;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IProduct;
import com.ai.crm.product.domain.model.interfaces.IProductPriceRel;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ProductPriceRel extends InstanceEntity implements IProductPriceRel {
	@JsonIgnore
	private IProduct product;
	@JsonIgnore
	private IPricePlanInstance price;
	public ProductPriceRel() {
	}

	@Override
	public IProduct getProduct() {
		return this.product;
	}

	@Override
	public void setProduct(IProduct product) {
		this.product=product;
	}

	@Override
	public IPricePlanInstance getPricePlanInstance() {
		return this.price;
	}

	@Override
	public void setPricePlanInstance(IPricePlanInstance price) {
		this.price=price;
	}

}
