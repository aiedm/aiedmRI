package com.ai.crm.customerorder.domain.service.interfaces;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;

public interface ICreateCustomerOrder {
	void createCustomerOrder(ICustomerOrder customerOrder);
	void createNewOfferOrder(IOfferOrder offerOrder);
	void createNewProductOrder(IProductOrder productOrder);
	void distributeOrderLineCreate(ICustomerOrder customerOrder);
	boolean isCustomerOrderCreateFinishedOfLastOfferOrder(IOfferOrder offerOrder);
	boolean isCustomerOrderCreateFinishedOfLastProductOrder(IProductOrder productOrder);
	boolean isOfferOrderCreateFinishedOfLastProductOrder(IProductOrder productOrder);
	boolean isSubmitOrder(ICustomerOrder customerOrder);
	public void startCreateProductOrdersOfOfferOrder(IOfferOrder offerOrder);
}
