package com.ai.crm.customerorder.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.domain.event.createorder.SubscribeProductOrderCreated;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateProductOrder;
import com.ai.crm.product.domain.model.AsIsProduct;
import java.sql.Timestamp;

@Component
public class CreateProductOrder implements ICreateProductOrder {
	@Autowired
	private IEventPublisher eventPublisher;
	public CreateProductOrder() {
	}

	@Override
	public void createSubscribeProductOrder(ProductOrderItem productOrder)  throws Exception{
		productOrder.setProductOrderState(ProductOrderItem.ProductOrderState.CREATED.getValue());		
		SubscribeProductOrderCreated event=new SubscribeProductOrderCreated(this);
		event.setProductOrder(productOrder);
		eventPublisher.publishEvent(event);
	}

	@Override
	public void createUnSubscribeProductOrder(AsIsProduct asIsProduct, Timestamp endTime) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
