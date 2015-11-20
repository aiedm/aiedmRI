package com.ai.crm.customerorder.application.service.api.adapter.interfaces;

import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.customerorder.domain.model.ToBeProduct;

public interface IProductItemDTOToOrder {
	ProductOrderItem transDTOToOrder(ProductOrderItemDTO productOrderItemDTO,CustomerOrder customerOrder) throws Exception;
	ToBeProduct transferToBeProduct(ToBeProductDTO toBeProductDTO) throws Exception;
}
