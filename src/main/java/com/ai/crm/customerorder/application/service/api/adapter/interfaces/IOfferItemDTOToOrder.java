package com.ai.crm.customerorder.application.service.api.adapter.interfaces;

import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;

public interface IOfferItemDTOToOrder {
	OfferOrderItem transDTOToOrder(OfferOrderItemDTO offerOrderItemDTO,CustomerOrder customerOrder) throws Exception;
}
