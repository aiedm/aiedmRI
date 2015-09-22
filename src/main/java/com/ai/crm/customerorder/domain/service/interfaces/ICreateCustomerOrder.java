package com.ai.crm.customerorder.domain.service.interfaces;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;

public interface ICreateCustomerOrder {
	void createCustomerOrder(ICustomerOrder customerOrder) throws Exception;
	void createNewOfferOrder(IOfferOrder offerOrder) throws Exception;
	void createNewProductOrder(IProductOrder productOrder) throws Exception;
	void distributeOrderLineCreate(ICustomerOrder customerOrder) throws Exception;
	boolean isCustomerOrderCreateFinishedOfLastOfferOrder(IOfferOrder offerOrder) throws Exception;
	boolean isCustomerOrderCreateFinishedOfLastProductOrder(IProductOrder productOrder) throws Exception;
	boolean isOfferOrderCreateFinishedOfLastProductOrder(IProductOrder productOrder) throws Exception;
	boolean isSubmitOrder(ICustomerOrder customerOrder) throws Exception;
	public void startCreateProductOrdersOfOfferOrder(IOfferOrder offerOrder) throws Exception;
}
