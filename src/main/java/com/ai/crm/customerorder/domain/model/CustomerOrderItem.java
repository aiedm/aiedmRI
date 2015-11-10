package com.ai.crm.customerorder.domain.model;

import com.ai.crm.common.businessinteraction.domain.model.BusinessInteraction;
import com.ai.crm.common.businessinteraction.domain.model.BusinessInteractionItem;

public class CustomerOrderItem extends BusinessInteractionItem  {

	public CustomerOrderItem() {
	}

	public CustomerOrderItem(BusinessInteraction bi) {
		super(bi);
	}

}
