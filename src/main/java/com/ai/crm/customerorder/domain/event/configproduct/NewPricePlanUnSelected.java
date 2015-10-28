package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance;

public class NewPricePlanUnSelected {
	//get products from offer instance,if need,create new product to offer instance
	private IToBePricePlanInstance toBePricePlanInstance;
	public IToBePricePlanInstance getToBePricePlanInstance() {
		return toBePricePlanInstance;
	}
	public void setToBePricePlanInstance(IToBePricePlanInstance toBePricePlanInstance) {
		this.toBePricePlanInstance = toBePricePlanInstance;
	}
	public NewPricePlanUnSelected() {
	}

}
