package com.ai.crm.customer.repository.interfaces;

import com.ai.crm.customer.domain.model.IndividualCustomer;
import com.ai.crm.customer.domain.model.LegalCustomer;


public interface ICustomerRepository {
	IndividualCustomer saveIndividualCustomer(IndividualCustomer individualCustomer);
	LegalCustomer saveLegalCustomer(LegalCustomer legalCustomer); 
	IndividualCustomer findIndividualCustomer(long customerId);
	LegalCustomer findLegalCustomer(long customerId);
}
