package com.ai.crm.customerorder.domain.model.impl;

import com.ai.crm.common.businessinteraction.domain.model.impl.BusinessInteractionItem;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteraction;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrderItem;

public class CustomerOrderItem extends BusinessInteractionItem implements ICustomerOrderItem {

	public CustomerOrderItem() {
		// TODO Auto-generated constructor stub
	}

	public CustomerOrderItem(IBusinessInteraction bi) {
		super(bi);
		// TODO Auto-generated constructor stub
	}

}