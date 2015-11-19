package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Table(name="PD_PRODUCT_PRICE_REL")
public class ProductPriceRel extends InstanceEntity{
	@ManyToOne
	private Product product;
	@ManyToOne
	private PricePlanInstance price;
	@Id
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
	public ProductPriceRel() {
	}

	
	public Product getProduct() {
		return this.product;
	}

	
	public void setProduct(Product product) {
		this.product=product;
	}

	
	public PricePlanInstance getPricePlanInstance() {
		return this.price;
	}

	
	public void setPricePlanInstance(PricePlanInstance price) {
		this.price=price;
	}

}
