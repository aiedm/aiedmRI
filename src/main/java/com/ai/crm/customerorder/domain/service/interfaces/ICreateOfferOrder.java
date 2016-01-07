package com.ai.crm.customerorder.domain.service.interfaces;

import com.ai.crm.customerorder.domain.model.OfferOrderItem;

public interface ICreateOfferOrder {
	void createSubscribeOfferOrder(OfferOrderItem offerOrder) throws Exception;
	void createUnSubscribeOfferOrder(OfferOrderItem offerOrder) throws Exception;

}
