package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.ToBePricePlanInstance;

public class NewPricePlanSelected extends BaseEvent {
	//get products from offer instance,if need,create new product to offer instance
	private ToBePricePlanInstance toBePricePlanInstance;
	public ToBePricePlanInstance getToBePricePlanInstance() {
		return toBePricePlanInstance;
	}
	public void setToBePricePlanInstance(ToBePricePlanInstance toBePricePlanInstance) {
		this.toBePricePlanInstance = toBePricePlanInstance;
	}
	public NewPricePlanSelected(Object source) {
		super(source);
	}

}
