package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;

import com.ai.crm.common.businessinteraction.domain.model.BusinessInteraction;
import com.ai.crm.common.businessinteraction.domain.model.BusinessInteractionItem;
@Entity
public class CustomerOrderItem extends BusinessInteractionItem  {

	public CustomerOrderItem() {
	}

	public CustomerOrderItem(BusinessInteraction bi) {
		super(bi);
	}

}
