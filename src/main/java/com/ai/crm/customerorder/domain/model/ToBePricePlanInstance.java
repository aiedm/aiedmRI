package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.PricePlanInstance;
@Entity
@Table(name="ORD_TOBE_PRICE_INS")
public class ToBePricePlanInstance extends PricePlanInstance{
	@OneToOne
	private PricePlanInstance asIsPricePlanInstance;
	public PricePlanInstance getAsIsPricePlanInstance() {
		return asIsPricePlanInstance;
	}

	public void setAsIsPricePlanInstance(PricePlanInstance pricePlanInstance) {
		this.asIsPricePlanInstance=pricePlanInstance;
	}

}
