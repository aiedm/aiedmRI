package com.ai.crm.customerorder.domain.service.interfaces;

import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewProductOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;

public interface ICheckCustomerOrder {
	public void checkCreateOrderRequest(CreateOrderRequested event)  throws Exception;
	public void checkCreateNewOfferOrderRequest(CheckNewOfferOrderRequested event)  throws Exception;
	public void checkCreateNewProductOrderRequest(CheckNewProductOrderRequested event)  throws Exception;
}
