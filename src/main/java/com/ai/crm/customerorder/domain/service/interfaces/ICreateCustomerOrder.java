package com.ai.crm.customerorder.domain.service.interfaces;

import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityPassed;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;


public interface ICreateCustomerOrder {
	void createCustomerOrder(CheckOrderCustomerAvalibityPassed event) throws Exception;
	void createCustomerOrder(CustomerOrder customerOrder,long shoppingCartId) throws Exception;
	void distributeOrderItemCreate(CustomerOrder customerOrder) throws Exception;
	boolean isCustomerOrderCreateFinishedOfLastOfferOrder(OfferOrderItem offerOrder) throws Exception;
	boolean isCustomerOrderCreateFinishedOfLastProductOrder(ProductOrderItem productOrder) throws Exception;
	void startOrder(CustomerOrder customerOrder) throws Exception;
	String generateCustomerOrderCode() throws Exception;
	void saveCustomerOrder(CustomerOrder customerOrder) throws Exception ;
}
