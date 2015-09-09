package com.ai.crm.customer.domain.model.interfaces;

import com.ai.crm.common.party.domain.model.interfaces.ILegalOrganization;

public interface ILegalCustomer extends ICustomer {
	ILegalOrganization getLegalOrganization();
}
