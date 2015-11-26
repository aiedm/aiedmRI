package com.ai.crm.customerorder.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ai.common.basetype.TimePeriod;
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
@Transactional
@Rollback(false)
public class CustomerOrderTests {
	private OfferOrderItemDTO offerOrderDTO = new OfferOrderItemDTO();
	private CustomerOrderDTO customerOrderDTO=new CustomerOrderDTO();
	private ToBePricePlanInstanceDTO toBePriceDTO=new ToBePricePlanInstanceDTO();
	private CharacterInstanceDTO OfferInstancePriceCharacterDTO=new CharacterInstanceDTO();
	private ToBeOfferInstanceDTO toBeOfferInstanceDTO=new ToBeOfferInstanceDTO();
	private ToBeProductDTO toBeProductDTO=new ToBeProductDTO();	
	private CharacterValueInstanceDTO offerInstancePriceCharacterDTO=new CharacterValueInstanceDTO();

	@Autowired
	private IEventPublisher eventPublisher;
	@Autowired
	private ICustomerOrderRepository customerOrderRepository;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	
	@Test
	//@Ignore
	public void createCustomerOrder() throws Exception{
		toBePriceDTO.setPricePlanId(1);
		toBePriceDTO.setInputedValue(10000);
		
		toBeOfferInstanceDTO.addPricePlanInstance(toBePriceDTO);
		toBeOfferInstanceDTO.setProductOfferingId(11);
		toBeOfferInstanceDTO.setAcition(1);
		
		offerInstancePriceCharacterDTO.setCharacteristicSpecValueId(10001);
		offerInstancePriceCharacterDTO.setInputedValue("50%");	
		OfferInstancePriceCharacterDTO.setCharacteristicSpecId(100);
		OfferInstancePriceCharacterDTO.addCharacteristicValue(offerInstancePriceCharacterDTO);
		
		toBeOfferInstanceDTO.addOfferInstanceCharacteristic(OfferInstancePriceCharacterDTO);
		
		offerOrderDTO.setBusinessInteractionItemSpecId(1001);
		offerOrderDTO.setToBeOfferInstanceTDO(toBeOfferInstanceDTO);	
		offerOrderDTO.setAction(1);
		toBeProductDTO.setProductSpecId(101);
		TimePeriod prodRelValidPeriod=new TimePeriod();
		//prodRelValidPeriod.setBeginTime(beginTime);
		//prodRelValidPeriod.setEndTime(beginTime);
		toBePriceDTO.applyToProduct(toBeProductDTO,prodRelValidPeriod);
		CharacterValueInstanceDTO productcharacterInstanceValue=new CharacterValueInstanceDTO();
		productcharacterInstanceValue.setCharacteristicSpecValueId(20001);
		productcharacterInstanceValue.setInputedValue("Red");
		CharacterInstanceDTO productPriceCharacter=new CharacterInstanceDTO();
		productPriceCharacter.setCharacteristicSpecId(200);
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
