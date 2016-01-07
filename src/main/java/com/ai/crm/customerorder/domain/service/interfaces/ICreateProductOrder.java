package com.ai.crm.customerorder.domain.service.interfaces;

import java.sql.Timestamp;

import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.product.domain.model.AsIsProduct;

public interface ICreateProductOrder {
	void createSubscribeProductOrder(ProductOrderItem productOrder) throws Exception;
	void createUnSubscribeProductOrder(AsIsProduct asIsProduct,Timestamp endTime) throws Exception;
}
