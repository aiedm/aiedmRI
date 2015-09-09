package com.ai.crm.customer.repository.interfaces;

import com.ai.crm.customer.domain.model.interfaces.IIndividualCustomer;
import com.ai.crm.customer.domain.model.interfaces.ILegalCustomer;


public interface ICustomerRepository {
	IIndividualCustomer saveIndividualCustomer(IIndividualCustomer individualCustomer);
	ILegalCustomer saveLegalCustomer(ILegalCustomer legalCustomer); 
	IIndividualCustomer findIndividualCustomer(long customerId);
	ILegalCustomer findLegalCustomer(long customerId);
}
