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

import com.ai.common.rootentity.domain.model.impl.InstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.impl.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.impl.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.impl.InstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.common.businessinteraction.domain.model.impl.BIIRelatedEntity;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBIIRelatedEntity;
import com.ai.crm.config.DevelopmentProfileConfig;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;
import com.ai.crm.customerorder.domain.model.impl.CustomerOrder;
import com.ai.crm.customerorder.domain.model.impl.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.impl.ProductOrderItem;
import com.ai.crm.customerorder.domain.model.impl.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.impl.ToBeProduct;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
import com.ai.crm.product.domain.model.interfaces.IProductPriceRel;
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
	private IToBePricePlanInstance toBePrice;
	@Autowired
	private IInstanceEntityCharacter OfferInstancePriceCharacter;
	@Autowired
	private IToBeOfferInstance toBeOfferInstance;
	@Autowired
	private IToBeProduct toBeProduct;	
	@Autowired
	private IProductPriceRel productPriceRel;
	
	@Autowired
	private IInstanceEntityCharacterValue characteristicInstanceValue;
	@Autowired
	private ICharacteristicSpec characteristicSpec;
	@Autowired
	private ICharacteristicSpecValue characteristicValue;
	@Autowired
	private IInstanceEntityCharacter productCharacteristic;
	@Autowired
	private IEventPublisher eventPublisher;
	
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	@Transactional
	//@Ignore
	public void createCustomerOrder() throws Exception{
		toBeProduct.setProductSpecificationId(101);
		productPriceRel.setProduct(toBeProduct);
		toBeProduct.assignPrice(productPriceRel);
		offerOrder.setBusinessInteractionItemSpecId(1001);
		offerOrder.setOfferOrderId(2);
		offerOrder.setOfferOrderState(IOfferOrderItem.OfferOrderState.INITIATED.getValue());
		toBeOfferInstance.setProductOfferingId(11);
		toBeOfferInstance.addProduct(toBeProduct);
		IBIIRelatedEntity relatedTobeOfferInstance=new BIIRelatedEntity();
		relatedTobeOfferInstance.setToBeInstanceEntity(toBeOfferInstance);
		relatedTobeOfferInstance.setAction(IBIIRelatedEntity.Action.CREATE.getValue());
		offerOrder.setRelatedEntity(relatedTobeOfferInstance);
		toBeOfferInstance.addPricePlanInstance(toBePrice);
		toBePrice.setPricePlanId(1);
		toBePrice.setPriceValue(10000);
		productPriceRel.setPricePlanInstance(toBePrice);
		characteristicValue.setId(1101);
		characteristicValue.setValue("50%");
		characteristicSpec.addValue(characteristicValue);
		characteristicSpec.setId(100);
		characteristicInstanceValue.setId(100004);
		characteristicInstanceValue.setInputedValue("50%");		
		characteristicInstanceValue.setCharacteristicValue(characteristicValue);
		OfferInstancePriceCharacter.addCharacteristicInstanceValue(characteristicInstanceValue);
		toBePrice.addCharacteristic(OfferInstancePriceCharacter);
		
		ICharacteristicSpecValue characteristicValue2=new CharacteristicSpecValue();
		characteristicValue2.setId(1102);
		characteristicValue2.setValue("Red");	
		ICharacteristicSpec characteristic2=new CharacteristicSpec();
		characteristic2.addValue(characteristicValue2);
		characteristic2.setId(110);
		
		IInstanceEntityCharacterValue characteristicInstanceValue2=new InstanceEntityCharacterValue(productCharacteristic,characteristicValue2);
		characteristicInstanceValue2.setId(100005);
		characteristicInstanceValue2.setInputedValue("Red");
		productCharacteristic=new InstanceEntityCharacter();
		productCharacteristic.addCharacteristicInstanceValue(characteristicInstanceValue2);
		toBeOfferInstance.addCharacteristic(productCharacteristic);
		customerOrder.setOrderState(ICustomerOrder.CustomerOrderState.INITIATED.getValue());
		customerOrder.setCustomerOrderCode("201509080001");
		customerOrder.addOfferOrder(offerOrder);
		IOfferOrderItem offerOrder2=new OfferOrderItem(customerOrder);
		offerOrder2.setOfferOrderId(5);
		offerOrder2.setOfferOrderState(IOfferOrderItem.OfferOrderState.INITIATED.getValue());
		offerOrder2.setBusinessInteractionItemSpecId(1001);
		IToBeProduct toBeproduct2=new ToBeProduct();
		toBeproduct2.setProductSpecificationId(102);
		IToBeOfferInstance toBeOffer2=new ToBeOfferInstance();
		toBeOffer2.setProductOfferingId(12);
		toBeOffer2.addProduct(toBeproduct2);
		IBIIRelatedEntity relatedOffer2=new BIIRelatedEntity();
		relatedOffer2.setToBeInstanceEntity(toBeOffer2);
		relatedOffer2.setAction(IBIIRelatedEntity.Action.CREATE.getValue());
		offerOrder2.setRelatedEntity(relatedOffer2);
		customerOrder.addOfferOrder(offerOrder2);
		CreateOrderRequested event=new CreateOrderRequested(this);
		event.setCustomerOrder(customerOrder);
		eventPublisher.publishEvent(event);
		assertEquals(IOfferOrderItem.OfferOrderState.CREATED.getValue(),offerOrder.getOfferOrderState());
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
