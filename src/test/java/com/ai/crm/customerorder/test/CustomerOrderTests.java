package com.ai.crm.customerorder.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CharacterValueInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBePricePlanInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@ActiveProfiles("dev")
public class CustomerOrderTests {
	private OfferOrderItemDTO offerOrder = new OfferOrderItemDTO();
	private CustomerOrderDTO customerOrder=new CustomerOrderDTO();
	private ToBePricePlanInstanceDTO toBePrice=new ToBePricePlanInstanceDTO();
	private CharacterInstanceDTO OfferInstancePriceCharacter=new CharacterInstanceDTO();
	private ToBeOfferInstanceDTO toBeOfferInstance=new ToBeOfferInstanceDTO();
	private ToBeProductDTO toBeProduct=new ToBeProductDTO();	
	private CharacterValueInstanceDTO offerInstancePriceCharacter=new CharacterValueInstanceDTO();

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
		assertEquals(0,customerOrder.getCustomerId());
		String jsonString=mapper.writeValueAsString(customerOrder);
		mapper.writeValue(new File("D:\\workspace\\springTest\\aiedmRI\\src\\test\\resource\\order.json"), customerOrder);
		System.out.println(jsonString);
	}
	
	@Test
	@Ignore
	public void getCustomerFromJson() throws Exception{
		CustomerOrderDTO object=mapper.readValue(new File("D:\\workspace\\springTest\\aiedmRI\\src\\test\\resource\\order.json"), CustomerOrderDTO.class);
		System.out.println(object.getCustomerOrderCode());
	}
	
}
