package com.ai.crm.customerorder.test;

import static org.junit.Assert.assertEquals;

import java.io.CharConversionException;
import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.common.basetype.TimePeriod;
import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.repository.impl.CharacteristiceSpecRepository;
import com.ai.common.rootentity.domain.repository.interfaces.ICharacteristiceSpecRepository;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CharacterValueInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBePricePlanInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.repository.interfaces.ICustomerOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@ActiveProfiles("dev")
public class CustomerOrderTests {
	private OfferOrderItemDTO offerOrderDTO = new OfferOrderItemDTO();
	private CustomerOrderDTO customerOrderDTO=new CustomerOrderDTO();
	private ToBePricePlanInstanceDTO toBePriceDTO=new ToBePricePlanInstanceDTO();
	private CharacterInstanceDTO priceInstanceCharacterDTO=new CharacterInstanceDTO();
	private ToBeOfferInstanceDTO toBeOfferInstanceDTO=new ToBeOfferInstanceDTO();
	private ToBeProductDTO toBeProductDTO=new ToBeProductDTO();	
	private CharacterValueInstanceDTO priceInstanceCharacterValueDTO=new CharacterValueInstanceDTO();

	@Autowired
	private IEventPublisher eventPublisher;
	@Autowired
	private ICustomerOrderRepository customerOrderRepository;
	@Autowired
	private ICharacteristiceSpecRepository characteristiceSpecRepository;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	
	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Rollback(false)
	public void createCustomerOrder() throws Exception{
		CharacteristicSpec characterSpec1=new CharacteristicSpec();
		//characterSpec1.setId(1);
		characterSpec1.setName("discount");
		characterSpec1.setCode("DISCOUNT");
		CharacteristicSpecValue characterSpecValue1= new CharacteristicSpecValue();
		//characterSpecValue1.setId(1);
		characterSpecValue1.setCode("50%");		
		characterSpec1.addValue(characterSpecValue1);
		
		CharacteristicSpec characterSpec2=new CharacteristicSpec();
		//characterSpec2.setId(2);
		characterSpec2.setName("color");
		characterSpec2.setCode("COLOR");
		CharacteristicSpecValue characterSpecValue2= new CharacteristicSpecValue();
		//characterSpecValue2.setId(2);
		characterSpec2.addValue(characterSpecValue2);	
		//characteristiceSpecRepository.saveCharactericSpecValue(characterSpecValue1);
		//characteristiceSpecRepository.saveCharactericSpecValue(characterSpecValue2);
		characteristiceSpecRepository.saveCharactericSpec(characterSpec1);
		characteristiceSpecRepository.saveCharactericSpec(characterSpec2);		
		
		toBePriceDTO.setPricePlanId(1);
		toBePriceDTO.setInputedValue(10000);
		
		toBeOfferInstanceDTO.addPricePlanInstance(toBePriceDTO);
		toBeOfferInstanceDTO.setProductOfferingId(11);
		toBeOfferInstanceDTO.setAcition(1);
		
		priceInstanceCharacterValueDTO.setCharacteristicSpecValueId(1);
		priceInstanceCharacterValueDTO.setInputedValue("50%");	
		priceInstanceCharacterDTO.setCharacteristicSpecId(1);
		priceInstanceCharacterDTO.addCharacteristicValue(priceInstanceCharacterValueDTO);
		
		toBePriceDTO.addPricePlanInstanceCharacteristics(priceInstanceCharacterDTO);
		
		offerOrderDTO.setBusinessInteractionItemSpecId(1001);
		offerOrderDTO.setToBeOfferInstanceTDO(toBeOfferInstanceDTO);	
		offerOrderDTO.setAction(1);
		toBeProductDTO.setProductSpecId(101);
		TimePeriod prodRelValidPeriod=new TimePeriod();
		//prodRelValidPeriod.setBeginTime(beginTime);
		//prodRelValidPeriod.setEndTime(beginTime);
		toBePriceDTO.applyToProduct(toBeProductDTO,prodRelValidPeriod);
		CharacterValueInstanceDTO productcharacterInstanceValue=new CharacterValueInstanceDTO();
		productcharacterInstanceValue.setCharacteristicSpecValueId(2);
		productcharacterInstanceValue.setInputedValue("Red");
		CharacterInstanceDTO productPriceCharacter=new CharacterInstanceDTO();
		productPriceCharacter.setCharacteristicSpecId(2);
		productPriceCharacter.addCharacteristicValue(productcharacterInstanceValue);
		toBeProductDTO.addProductCharacteristics(productPriceCharacter);
		toBeOfferInstanceDTO.addProduct(toBeProductDTO,prodRelValidPeriod);
	
		customerOrderDTO.addOfferOrderItem(offerOrderDTO);
		
		OfferOrderItemDTO offerOrder2=new OfferOrderItemDTO();
		offerOrder2.setAction(1);
		offerOrder2.setBusinessInteractionItemSpecId(1001);
		ToBeProductDTO toBeproduct2=new ToBeProductDTO();
		toBeproduct2.setProductSpecId(102);
		ToBeOfferInstanceDTO toBeOffer2=new ToBeOfferInstanceDTO();
		toBeOffer2.setProductOfferingId(12);
		toBeOffer2.addProduct(toBeproduct2,prodRelValidPeriod);
		offerOrder2.setToBeOfferInstanceTDO(toBeOffer2);
		
		customerOrderDTO.addOfferOrderItem(offerOrder2);
		
		CreateOrderRequested event=new CreateOrderRequested(this);
		event.setCustomerOrderDTO(customerOrderDTO);
		eventPublisher.publishEvent(event);
		assertEquals(0,customerOrderDTO.getCustomerId());
		String jsonString=mapper.writeValueAsString(customerOrderDTO);
		mapper.writeValue(new File("D:\\workspace\\springTest\\aiedmRI\\src\\test\\resource\\order.json"), customerOrderDTO);
		System.out.println(jsonString);
	}
	
	@Test
	@Ignore
	public void getCustomerFromJson() throws Exception{
		CustomerOrderDTO object=mapper.readValue(new File("D:\\workspace\\springTest\\aiedmRI\\src\\test\\resource\\order.json"), CustomerOrderDTO.class);
		System.out.println(object.getCustomerOrderCode());
	}
	
}
