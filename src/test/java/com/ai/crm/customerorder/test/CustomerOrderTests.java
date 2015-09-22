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

import com.ai.crm.common.characteristic.domain.model.impl.Characteristic;
import com.ai.crm.common.characteristic.domain.model.impl.CharacteristicValue;
import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristic;
import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;
import com.ai.crm.config.DevelopmentProfileConfig;
import com.ai.crm.customerorder.application.service.api.web.OrderDeserializer;
import com.ai.crm.customerorder.domain.event.CreateOrderRequested;
import com.ai.crm.customerorder.domain.model.impl.CustomerOrder;
import com.ai.crm.customerorder.domain.model.impl.OfferOrder;
import com.ai.crm.customerorder.domain.model.impl.ProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPrice;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPriceCharacteristicValue;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderCharacteristicValue;
import com.ai.flyingshuttle.base.service.interfaces.IEventPublisher;
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
	private IProductOrder productOrder;	
	@Autowired
	private IOfferOrder offerOrder;
	@Autowired
	private ICustomerOrder customerOrder;
	@Autowired
	private IOrderPrice orderPrice;
	@Autowired
	private IOrderPriceCharacteristicValue priceCharacterValue;
	@Autowired
	private ICharacteristic characteristic;
	@Autowired
	private ICharacteristicValue characteristicValue;
	@Autowired
	private IProductOrderCharacteristicValue productOrderCharacteristicValue;
	@Autowired
	private IEventPublisher eventPublisher;
	
	
	private ObjectMapper mapper = new ObjectMapper();
	private OrderDeserializer orderDeserializer;
	@Before
	public void prepare(){
		orderDeserializer=new OrderDeserializer();
		orderDeserializer.registerOrderItem("ICustomerOrder", CustomerOrder.class);
		orderDeserializer.registerOrderItem("IOfferOrder", OfferOrder.class);
		orderDeserializer.registerOrderItem("IProductOrder", ProductOrder.class);
		SimpleModule orderModule = new SimpleModule("OrderModule");
		orderModule.addDeserializer(ICustomerOrder.class, orderDeserializer);
		mapper.registerModule(orderModule);
	}
	
	@Test
	@Transactional
	//@Ignore
	public void createCustomerOrder() throws Exception{
		productOrder.setProductOrderId(3);
		productOrder.setProductOrderState(IProductOrder.ProductOrderState.INITIATED.getValue());
		offerOrder.setOfferOrderId(2);
		offerOrder.setOfferOrderState(IOfferOrder.OfferOrderState.INITIATED.getValue());
		offerOrder.addProductOrder(productOrder);
		orderPrice.setPricePlanId(1);
		orderPrice.setPriceValue(10000);
		characteristicValue.setId(1001);
		characteristicValue.setValue("50%");	
		characteristic.addValue(characteristicValue);
		characteristic.setId(100);
		characteristic.setName("Discount");
		characteristic.setCode("DISCOUNT");
		priceCharacterValue.setCharacteristicValue(characteristicValue);
		orderPrice.addPriceCharacterValue(priceCharacterValue);
		offerOrder.addPrice(orderPrice);
		productOrder.addPrice(orderPrice);
		ICharacteristicValue characteristicValue2=new CharacteristicValue();
		characteristicValue2.setId(1102);
		characteristicValue2.setValue("Red");	
		ICharacteristic characteristic2=new Characteristic();
		characteristic2.addValue(characteristicValue2);
		characteristic2.setId(110);
		characteristic2.setName("Color");	
		characteristic2.setCode("COLOR");
		productOrderCharacteristicValue.setCharacteristicValue(characteristicValue2);
		productOrder.addProductOrderCharacteristic(productOrderCharacteristicValue);
		IProductOrder productOrder2=new ProductOrder(offerOrder);
		productOrder2.setProductOrderId(4);
		productOrder2.setProductOrderState(IProductOrder.ProductOrderState.INITIATED.getValue());				
		customerOrder.setCustomerOrderId(1);
		customerOrder.setOrderState(ICustomerOrder.CustomerOrderState.INITIATED.getValue());
		customerOrder.setCustomerOrderCode("201509080001");
		customerOrder.addOfferOrder(offerOrder);
		IOfferOrder offerOrder2=new OfferOrder(customerOrder);
		offerOrder2.setOfferOrderId(5);
		offerOrder2.setOfferOrderState(IOfferOrder.OfferOrderState.INITIATED.getValue());
		IProductOrder productOrder3=new ProductOrder(offerOrder2);
		productOrder3.setProductOrderId(6);
		productOrder3.setProductOrderState(IProductOrder.ProductOrderState.INITIATED.getValue());
		customerOrder.addOfferOrder(offerOrder2);
		CreateOrderRequested event=new CreateOrderRequested(this);
		event.setCustomerOrder(customerOrder);
		eventPublisher.publishEvent(event);
		assertEquals(IProductOrder.ProductOrderState.CREATED.getValue(),productOrder.getProductOrderState());
		assertEquals(IProductOrder.ProductOrderState.CREATED.getValue(),productOrder2.getProductOrderState());		
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
