package com.ai.crm.customerorder.test;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.crm.config.DevelopmentProfileConfig;
import com.ai.crm.customerorder.domain.event.CreateOrderRequested;
import com.ai.crm.customerorder.domain.model.impl.OfferOrder;
import com.ai.crm.customerorder.domain.model.impl.ProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.flyingshuttle.base.service.interfaces.IEventPublisher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DevelopmentProfileConfig.class)
@ActiveProfiles("dev")
public class CustomerOrderTests{
	@Autowired 
	private IProductOrder productOrder;	
	@Autowired
	private IOfferOrder offerOrder;
	@Autowired
	private ICustomerOrder customerOrder;
	@Autowired
	private IEventPublisher eventPublisher;
	
	@Test
	@Transactional
	public void createCustomerOrder() {
		productOrder.setProductOrderId(3);
		productOrder.setProductOrderState(IProductOrder.ProductOrderState.INITIATED.getValue());
		offerOrder.setOfferOrderId(2);
		offerOrder.setOfferOrderState(IOfferOrder.OfferOrderState.INITIATED.getValue());
		offerOrder.addProductOrder(productOrder);
		IProductOrder productOrder2=new ProductOrder(offerOrder);
		productOrder2.setProductOrderId(4);
		productOrder2.setProductOrderState(IProductOrder.ProductOrderState.INITIATED.getValue());				
		customerOrder.setCustomerOrderId(1);
		customerOrder.setOrderState(ICustomerOrder.CustomerOrderState.INITIATED.getValue());
		customerOrder.setCustomerOrderCode("201509080001");
		customerOrder.addOfferOrder(offerOrder);
		offerOrder.addProductOrder(productOrder2);
		IOfferOrder offerOrder2=new OfferOrder(customerOrder);
		offerOrder2.setOfferOrderId(5);
		offerOrder2.setOfferOrderState(IOfferOrder.OfferOrderState.INITIATED.getValue());
		IProductOrder productOrder3=new ProductOrder(offerOrder);
		productOrder3.setProductOrderId(6);
		productOrder3.setProductOrderState(IProductOrder.ProductOrderState.INITIATED.getValue());
		offerOrder2.addProductOrder(productOrder3);
		customerOrder.addOfferOrder(offerOrder2);
		CreateOrderRequested event=new CreateOrderRequested(this);
		event.setCustomerOrder(customerOrder);
		eventPublisher.publishEvent(event);
		assertEquals(IProductOrder.ProductOrderState.CREATED.getValue(),productOrder.getProductOrderState());
		assertEquals(IProductOrder.ProductOrderState.CREATED.getValue(),productOrder2.getProductOrderState());
	}
}
