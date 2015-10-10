package com.ai.crm.customerorder.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ai.common.rootentity.domain.model.impl.CharacteristicInstanceValue;
import com.ai.common.rootentity.domain.model.impl.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.impl.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.impl.InstanceEntityCharacteristic;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicInstanceValue;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacteristic;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.config.DevelopmentProfileConfig;
import com.ai.crm.customerorder.domain.event.CreateOrderRequested;
import com.ai.crm.customerorder.domain.model.impl.CustomerOrder;
import com.ai.crm.customerorder.domain.model.impl.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.impl.ProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPrice;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.module.SimpleModule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@ActiveProfiles("dev")
public class CustomerOrderTests {
	@Autowired 
	private IProductOrderItem productOrder;	
	@Autowired
	private IOfferOrderItem offerOrder;
	@Autowired
	private ICustomerOrder customerOrder;
	@Autowired
	private IOrderPrice orderPrice;
	@Autowired
	private IInstanceEntityCharacteristic OfferOrderPriceCharacter;
	
	@Autowired
	private ICharacteristicInstanceValue characteristicInstanceValue;
	@Autowired
	private ICharacteristicSpec characteristicSpec;
	@Autowired
	private ICharacteristicSpecValue characteristicValue;
	@Autowired
	private IInstanceEntityCharacteristic productOrderCharacteristic;
	@Autowired
	private IEventPublisher eventPublisher;
	
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	@Transactional
	//@Ignore
	public void createCustomerOrder() throws Exception{
		productOrder.setProductOrderId(3);
		productOrder.setProductOrderState(IProductOrderItem.ProductOrderState.INITIATED.getValue());
		offerOrder.setOfferOrderId(2);
		offerOrder.setOfferOrderState(IOfferOrderItem.OfferOrderState.INITIATED.getValue());
		offerOrder.addProductOrder(productOrder);
		orderPrice.setPricePlanId(1);
		orderPrice.setPriceValue(10000);
		characteristicValue.setId(1101);
		characteristicValue.setValue("50%");
		characteristicSpec.addValue(characteristicValue);
		characteristicSpec.setId(100);
		characteristicInstanceValue.setId(100004);
		characteristicInstanceValue.setInputedValue("50%");		
		characteristicInstanceValue.setCharacteristicValue(characteristicValue);
		OfferOrderPriceCharacter.addCharacteristicInstanceValue(characteristicInstanceValue);
		orderPrice.addPriceCharacter(OfferOrderPriceCharacter);
		offerOrder.addPrice(orderPrice);
		productOrder.addPrice(orderPrice);
		
		ICharacteristicSpecValue characteristicValue2=new CharacteristicSpecValue();
		characteristicValue2.setId(1102);
		characteristicValue2.setValue("Red");	
		ICharacteristicSpec characteristic2=new CharacteristicSpec();
		characteristic2.addValue(characteristicValue2);
		characteristic2.setId(110);
		
		ICharacteristicInstanceValue characteristicInstanceValue2=new CharacteristicInstanceValue(productOrderCharacteristic,characteristicValue2);
		characteristicInstanceValue2.setId(100005);
		characteristicInstanceValue2.setInputedValue("Red");
		productOrderCharacteristic=new InstanceEntityCharacteristic();
		productOrderCharacteristic.addCharacteristicInstanceValue(characteristicInstanceValue2);
		productOrder.addProductOrderCharacteristic(productOrderCharacteristic);
		IProductOrderItem productOrder2=new ProductOrderItem(offerOrder);
		productOrder2.setProductOrderId(4);
		productOrder2.setProductOrderState(IProductOrderItem.ProductOrderState.INITIATED.getValue());				
		customerOrder.setCustomerOrderId(1);
		customerOrder.setOrderState(ICustomerOrder.CustomerOrderState.INITIATED.getValue());
		customerOrder.setCustomerOrderCode("201509080001");
		customerOrder.addOfferOrder(offerOrder);
		IOfferOrderItem offerOrder2=new OfferOrderItem(customerOrder);
		offerOrder2.setOfferOrderId(5);
		offerOrder2.setOfferOrderState(IOfferOrderItem.OfferOrderState.INITIATED.getValue());
		IProductOrderItem productOrder3=new ProductOrderItem(offerOrder2);
		productOrder3.setProductOrderId(6);
		productOrder3.setProductOrderState(IProductOrderItem.ProductOrderState.INITIATED.getValue());
		customerOrder.addOfferOrder(offerOrder2);
		CreateOrderRequested event=new CreateOrderRequested(this);
		event.setCustomerOrder(customerOrder);
		eventPublisher.publishEvent(event);
		assertEquals(IProductOrderItem.ProductOrderState.CREATED.getValue(),productOrder.getProductOrderState());
		assertEquals(IProductOrderItem.ProductOrderState.CREATED.getValue(),productOrder2.getProductOrderState());		
		String jsonString=mapper.writeValueAsString(customerOrder);
		mapper.writeValue(new File("D:\\workspace\\springTest\\aiedmRI\\src\\test\\resource\\order.json"), (ICustomerOrder)customerOrder);
		System.out.println(jsonString);
	}
	
	@Test
	@Ignore
	public void getCustomerFromJson() throws Exception{
		ICustomerOrder object=mapper.readValue(new File("D:\\workspace\\springTest\\aiedmRI\\src\\test\\resource\\order.json"), ICustomerOrder.class);
		System.out.println(object.getCustomerOrderCode());
	}
	
}
