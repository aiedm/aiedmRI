package com.ai.crm.customer.domain.model.interfaces;

import com.ai.crm.common.party.domain.model.interfaces.IPartyRole;

public interface ICustomer extends IPartyRole{
	String getCustomerName();
}
