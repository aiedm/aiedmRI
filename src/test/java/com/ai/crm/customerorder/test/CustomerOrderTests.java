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
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CharacterValueInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBePricePlanInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
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
	private ProductOrderItemDTO productOrder;	
	private OfferOrderItemDTO offerOrder;
	private CustomerOrderDTO customerOrder;
	private ToBePricePlanInstanceDTO toBePrice;
	private CharacterInstanceDTO OfferInstancePriceCharacter;
	private ToBeOfferInstanceDTO toBeOfferInstance;
	private ToBeProductDTO toBeProduct;	
	private CharacterValueInstanceDTO offerInstancePriceCharacter;

	@Autowired
	private IEventPublisher eventPublisher;
	
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	@Transactional
	//@Ignore
	public void createCustomerOrder() throws Exception{
		toBePrice.setPricePlanId(1);
		toBePrice.setInputedValue(10000);
		toBePrice.setTempSeqId(1);
		
		toBeOfferInstance.addPricePlanInstance(toBePrice);
		toBeOfferInstance.setProductOfferingId(11);
		toBeOfferInstance.setAcition(1);
		
		offerInstancePriceCharacter.setCharacteristicSpecValueId(10001);
		offerInstancePriceCharacter.setInputedValue("50%");	
		OfferInstancePriceCharacter.setCharacteristicSpecId(100);
		OfferInstancePriceCharacter.addCharacteristicValue(offerInstancePriceCharacter);
		
		toBeOfferInstance.addOfferInstanceCharacteristic(OfferInstancePriceCharacter);
		
		offerOrder.setBusinessInteractionItemSpecId(1001);
		offerOrder.setToBeOfferInstanceTDO(toBeOfferInstance);		
		toBeProduct.setProductSpecId(101);
		toBeProduct.addAssignedPriceTempSeq(1);
		CharacterValueInstanceDTO productcharacterInstanceValue=new CharacterValueInstanceDTO();
		productcharacterInstanceValue.setCharacteristicSpecValueId(20001);
		productcharacterInstanceValue.setInputedValue("Red");
		CharacterInstanceDTO productPriceCharacter=new CharacterInstanceDTO();
		productPriceCharacter.setCharacteristicSpecId(200);
		productPriceCharacter.addCharacteristicValue(productcharacterInstanceValue);
		toBeProduct.addProductCharacteristics(productPriceCharacter);
		toBeOfferInstance.addProduct(toBeProduct);
	
		customerOrder.addOfferOrderItem(offerOrder);
		
		OfferOrderItemDTO offerOrder2=new OfferOrderItemDTO();
		offerOrder2.setAction(1);
		offerOrder2.setBusinessInteractionItemSpecId(1001);
		ToBeProductDTO toBeproduct2=new ToBeProductDTO();
		toBeproduct2.setProductSpecId(102);
		ToBeOfferInstanceDTO toBeOffer2=new ToBeOfferInstanceDTO();
		toBeOffer2.setProductOfferingId(12);
		toBeOffer2.addProduct(toBeproduct2);
		offerOrder2.setToBeOfferInstanceTDO(toBeOffer2);
		
		customerOrder.addOfferOrderItem(offerOrder2);
		
		CreateOrderRequested event=new CreateOrderRequested(this);
		event.setCustomerOrderDTO(customerOrder);
		eventPublisher.publishEvent(event);
		assertEquals(1,customerOrder.getCustomerId());
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
