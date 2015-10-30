package com.ai.crm.customerorder.domain.service.interfaces;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IShoppingCart;

public interface ICreateCustomerOrder {
	void createCustomerOrder(ICustomerOrder customerOrder) throws Exception;
	void createCustomerOrder(ICustomerOrder customerOrder,long shoppingCartId) throws Exception;
	void createNewOfferOrder(IOfferOrderItem offerOrder) throws Exception;
	void createNewProductOrder(IProductOrderItem productOrder) throws Exception;
	void distributeOrderLineCreate(ICustomerOrder customerOrder) throws Exception;
	boolean isCustomerOrderCreateFinishedOfLastOfferOrder(IOfferOrderItem offerOrder) throws Exception;
	boolean isCustomerOrderCreateFinishedOfLastProductOrder(IProductOrderItem productOrder) throws Exception;
	boolean isOfferOrderCreateFinishedOfLastProductOrder(IProductOrderItem productOrder) throws Exception;
	void startCreateProductOrdersOfOfferOrder(IOfferOrderItem offerOrder) throws Exception;
	void startOrder(ICustomerOrder customerOrder) throws Exception;
}
