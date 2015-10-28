package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance;

public class NewPricePlanSelected extends BaseEvent {
	//get products from offer instance,if need,create new product to offer instance
	private IToBePricePlanInstance toBePricePlanInstance;
	public IToBePricePlanInstance getToBePricePlanInstance() {
		return toBePricePlanInstance;
	}
	public void setToBePricePlanInstance(IToBePricePlanInstance toBePricePlanInstance) {
		this.toBePricePlanInstance = toBePricePlanInstance;
	}
	public NewPricePlanSelected(Object source) {
		super(source);
	}

}
