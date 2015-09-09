package com.ai.crm.customer.domain.model.interfaces;

import com.ai.crm.common.party.domain.model.interfaces.IIndividual;

public interface IIndividualCustomer extends ICustomer {
	IIndividual getIndividual();
}
