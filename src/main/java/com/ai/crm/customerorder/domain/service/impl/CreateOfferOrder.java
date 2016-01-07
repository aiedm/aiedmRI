package com.ai.crm.customerorder.domain.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.basetype.TimePeriod;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.domain.event.createorder.SubscribeOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.UnSubscribeOfferOrderCreated;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstanceCharacter;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstanceCharacterValue;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstanceProductRel;
import com.ai.crm.customerorder.domain.model.ToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.ToBePricePlanInstanceCharacter;
import com.ai.crm.customerorder.domain.model.ToBePricePlanInstanceCharacterValue;
import com.ai.crm.customerorder.domain.model.ToBeProductPriceRel;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateOfferOrder;
import com.ai.crm.customerorder.domain.service.interfaces.ICreateProductOrder;
import com.ai.crm.product.domain.model.AsIsOfferInstance;
import com.ai.crm.product.domain.model.AsIsOfferInstanceCharacter;
import com.ai.crm.product.domain.model.AsIsOfferInstanceCharacterValue;
import com.ai.crm.product.domain.model.AsIsOfferInstanceProductRel;
import com.ai.crm.product.domain.model.AsIsPricePlanInstance;
import com.ai.crm.product.domain.model.AsIsPricePlanInstanceCharacter;
import com.ai.crm.product.domain.model.AsIsPricePlanInstanceCharacterValue;
import com.ai.crm.product.domain.model.AsIsProductPriceRel;
import com.ai.crm.product.domain.repository.interfaces.IProductRepository;
@Component
public class CreateOfferOrder implements ICreateOfferOrder {
	@Autowired
	private IEventPublisher eventPublisher;
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private ICreateProductOrder createProductOrder;
	
	public CreateOfferOrder() {
	}

	@Override
	public void createSubscribeOfferOrder(OfferOrderItem offerOrder)  throws Exception{
		offerOrder.setOfferOrderState(OfferOrderItem.OfferOrderState.CREATED.getValue());
		SubscribeOfferOrderCreated event=new SubscribeOfferOrderCreated(this);
		event.setOfferOrder(offerOrder);
		eventPublisher.publishEvent(event);
	}

	@Override
	public void createUnSubscribeOfferOrder(OfferOrderItem offerOrder) throws Exception {
		ToBeOfferInstance toBeOfferInstance=offerOrder.getToBeOfferInstance();
		long  asIsOfferInstanceId=toBeOfferInstance.getAsIsOfferInstance().getId();
		toBeOfferInstance.setAction(CustomerOrder.OrderAction.DELETE.getValue());
		AsIsOfferInstance asIsOfferInstance = productRepository.getOfferInstanceById(asIsOfferInstanceId);
		this.createUnsubscribeToBeOfferInstanceCharacter(toBeOfferInstance, asIsOfferInstance);
		this.createUnsubscribeToBePricePlanInstance(toBeOfferInstance, asIsOfferInstance);
		Set<AsIsOfferInstanceProductRel> products=asIsOfferInstance.getProducts();
		for (AsIsOfferInstanceProductRel asIsOfferInstanceProductRel : products) {
			ToBeOfferInstanceProductRel toBeOfferInstanceProductRel=new ToBeOfferInstanceProductRel();
			toBeOfferInstanceProductRel.setAsIsOfferInstanceProductRel(asIsOfferInstanceProductRel);
			toBeOfferInstanceProductRel.setOfferInstance(toBeOfferInstance);
			TimePeriod period=new TimePeriod();
			period.setBeginTime(asIsOfferInstanceProductRel.getValidPeriod().getBeginTime());
			period.setEndTime(toBeOfferInstance.getValidPeriod().getEndTime());
			toBeOfferInstanceProductRel.setValidPeriod(period);
			toBeOfferInstanceProductRel.setAction(CustomerOrder.OrderAction.DELETE.getValue());
			toBeOfferInstance.addProductRel(toBeOfferInstanceProductRel);
			if (asIsOfferInstanceProductRel.getRelType().equalsIgnoreCase("CREATE")){
				createProductOrder.createUnSubscribeProductOrder(asIsOfferInstanceProductRel.getProduct(), toBeOfferInstance.getValidPeriod().getEndTime());
			}
		}
		//TODO related offers
		
		UnSubscribeOfferOrderCreated event=new UnSubscribeOfferOrderCreated(this);
		event.setOfferOrder(offerOrder);
		eventPublisher.publishEvent(event);
	}
	
	private void createUnsubscribeToBeOfferInstanceCharacter(ToBeOfferInstance toBeOfferInstance,AsIsOfferInstance asIsOfferInstance) throws Exception{
		Set<AsIsOfferInstanceCharacter> asIsCharacters=asIsOfferInstance.getOfferInstanceCharacters();		
		for (AsIsOfferInstanceCharacter asIsOfferInstanceCharacter : asIsCharacters) {
			ToBeOfferInstanceCharacter toBeCharacter=new ToBeOfferInstanceCharacter();
			toBeCharacter.setOfferInstance(toBeOfferInstance);
			toBeCharacter.setCharacteristicSpec(asIsOfferInstanceCharacter.getCharacteristicSpec());
			TimePeriod period=new TimePeriod();
			period.setBeginTime(asIsOfferInstanceCharacter.getValidPeriod().getBeginTime());
			period.setEndTime(toBeOfferInstance.getValidPeriod().getEndTime());
			toBeCharacter.setValidPeriod(period);
			toBeCharacter.setAction(CustomerOrder.OrderAction.DELETE.getValue());
			toBeCharacter.setAsIsOfferInstanceCharacter(asIsOfferInstanceCharacter);
			Set<AsIsOfferInstanceCharacterValue> asIsCharacterValues=asIsOfferInstanceCharacter.getOfferInstanceCharacterValues();
			for (AsIsOfferInstanceCharacterValue asIsOfferInstanceCharacterValue : asIsCharacterValues) {
				ToBeOfferInstanceCharacterValue toBeCharacterValue=new ToBeOfferInstanceCharacterValue();
				toBeCharacterValue.setOfferInstanceCharacter(toBeCharacter);
				toBeCharacterValue.setAsIsOfferInstanceCharacter(asIsOfferInstanceCharacterValue);
				toBeCharacterValue.setAction(CustomerOrder.OrderAction.DELETE.getValue());
				TimePeriod valuePeriod=new TimePeriod();
				valuePeriod.setBeginTime(asIsOfferInstanceCharacterValue.getValidPeriod().getBeginTime());
				valuePeriod.setEndTime(toBeOfferInstance.getValidPeriod().getEndTime());
				toBeCharacterValue.setValidPeriod(valuePeriod);
				toBeCharacter.addCharacteristicInstanceValue(toBeCharacterValue);
			}			
			toBeOfferInstance.addOfferInstanceCharacter(toBeCharacter);
		}
	}

	private void createUnsubscribeToBePricePlanInstance(ToBeOfferInstance toBeOfferInstance,AsIsOfferInstance asIsOfferInstance) throws Exception{
		Set<AsIsPricePlanInstance> asIsPrices=asIsOfferInstance.getPricePlanInstances();
		for (AsIsPricePlanInstance asIsPricePlanInstance : asIsPrices) {
			ToBePricePlanInstance toBePricePlanInstance=new ToBePricePlanInstance();
			toBePricePlanInstance.setOfferInstance(toBeOfferInstance);
			toBePricePlanInstance.setAsIsPricePlanInstance(asIsPricePlanInstance);
			TimePeriod period=new TimePeriod();
			period.setBeginTime(asIsPricePlanInstance.getValidPeriod().getBeginTime());
			period.setEndTime(toBeOfferInstance.getValidPeriod().getEndTime());
			toBePricePlanInstance.setValidPeriod(period);
			toBePricePlanInstance.setAction(CustomerOrder.OrderAction.DELETE.getValue());
			toBePricePlanInstance.setPricePlanId(asIsPricePlanInstance.getPricePlanId());
			this.createUnsubscribeToBePricePlanInstanceCharacter(toBePricePlanInstance, asIsPricePlanInstance);
			Set<AsIsProductPriceRel> products=asIsPricePlanInstance.getAssignedTo();
			for (AsIsProductPriceRel asIsProductPriceRel : products) {
				ToBeProductPriceRel toBeProductPriceRel=new ToBeProductPriceRel();
				toBeProductPriceRel.setAsIsProductPriceRel(asIsProductPriceRel);
				toBeProductPriceRel.setPricePlanInstance(toBePricePlanInstance);
				toBeProductPriceRel.setAction(CustomerOrder.OrderAction.DELETE.getValue());
				TimePeriod productPeriod=new TimePeriod();
				productPeriod.setBeginTime(asIsProductPriceRel.getValidPeriod().getBeginTime());
				productPeriod.setEndTime(toBeOfferInstance.getValidPeriod().getEndTime());
				toBeProductPriceRel.setValidPeriod(productPeriod);
				toBePricePlanInstance.addProductPriceRel(toBeProductPriceRel);
			}
		}
	}
	
	private void createUnsubscribeToBePricePlanInstanceCharacter(ToBePricePlanInstance toBePricePlanInstance,AsIsPricePlanInstance asIsPricePlanInstance) throws Exception{
		Set<AsIsPricePlanInstanceCharacter> asIsCharacters=asIsPricePlanInstance.getPricePlanInstanceCharacters();		
		for (AsIsPricePlanInstanceCharacter asIsPriceInstanceCharacter : asIsCharacters) {
			ToBePricePlanInstanceCharacter toBeCharacter=new ToBePricePlanInstanceCharacter();
			toBeCharacter.setPricePlanInstance(toBePricePlanInstance);
			toBeCharacter.setCharacteristicSpec(asIsPriceInstanceCharacter.getCharacteristicSpec());
			TimePeriod period=new TimePeriod();
			period.setBeginTime(asIsPriceInstanceCharacter.getValidPeriod().getBeginTime());
			period.setEndTime(toBePricePlanInstance.getValidPeriod().getEndTime());
			toBeCharacter.setValidPeriod(period);
			toBeCharacter.setAction(CustomerOrder.OrderAction.DELETE.getValue());
			toBeCharacter.setAsIsPricePlanInstanceCharacter(asIsPriceInstanceCharacter);
			Set<AsIsPricePlanInstanceCharacterValue> asIsCharacterValues=asIsPriceInstanceCharacter.getPricePlanInstanceCharacterValues();
			for (AsIsPricePlanInstanceCharacterValue asIsPriceInstanceCharacterValue : asIsCharacterValues) {
				ToBePricePlanInstanceCharacterValue toBeCharacterValue=new ToBePricePlanInstanceCharacterValue();
				toBeCharacterValue.setPricePlanInstanceCharacter(toBeCharacter);
				toBeCharacterValue.setAsIsPricePlanInstanceCharacterValue(asIsPriceInstanceCharacterValue);
				toBeCharacterValue.setAction(CustomerOrder.OrderAction.DELETE.getValue());
				TimePeriod valuePeriod=new TimePeriod();
				valuePeriod.setBeginTime(asIsPriceInstanceCharacterValue.getValidPeriod().getBeginTime());
				valuePeriod.setEndTime(toBePricePlanInstance.getValidPeriod().getEndTime());
				toBeCharacterValue.setValidPeriod(valuePeriod);
				toBeCharacter.addCharacteristicInstanceValue(toBeCharacterValue);
			}			
			toBePricePlanInstance.addPricePlanInstanceCharacter(toBeCharacter);
		}
	}
}
