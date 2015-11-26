package com.ai.crm.customer.repository.interfaces;

import com.ai.crm.customer.domain.model.IndividualCustomer;
import com.ai.crm.customer.domain.model.LegalCustomer;


public interface ICustomerRepository {
	IndividualCustomer saveIndividualCustomer(IndividualCustomer individualCustomer) throws Exception;
	LegalCustomer saveLegalCustomer(LegalCustomer legalCustomer) throws Exception; 
	IndividualCustomer findIndividualCustomer(long customerId) throws Exception;
	LegalCustomer findLegalCustomer(long customerId) throws Exception;
}
