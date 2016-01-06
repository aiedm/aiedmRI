package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.common.basetype.TimePeriod;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = ToBeOfferInstanceDTO.class, name = "ToBeOfferInstanceDTO")
})
public class ToBeOfferInstanceDTO {
	private long productOfferingId;
	private long offerInstanceId;
	private long customerId;
	private int acition;
	private String name;
	private TimePeriod validPeriod;
	private Set<CharacterInstanceDTO> offerInstanceCharacteristics = new LinkedHashSet<CharacterInstanceDTO>();	
	private Set<ToBePricePlanInstanceDTO> pricePlanInstances = new LinkedHashSet<ToBePricePlanInstanceDTO>();
	
	private Set<NewSubscriberDTO> newSubscribers = new LinkedHashSet<NewSubscriberDTO>();	
	private Set<ToBeOfferInstanceProductDTO> products = new LinkedHashSet<ToBeOfferInstanceProductDTO>();

	public ToBeOfferInstanceDTO() {
	}

	public long getProductOffferingId() {
		return productOfferingId;
	}

	public void setProductOfferingId(long productOfferingId) {
		this.productOfferingId = productOfferingId;
	}

	public long getOfferInstanceId() {
		return offerInstanceId;
	}

	public void setOfferInstanceId(long offerInstanceId) {
		this.offerInstanceId = offerInstanceId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public int getAcition() {
		return acition;
	}

	public void setAcition(int acition) {
		this.acition = acition;
	}

	public Set<CharacterInstanceDTO> getOfferInstanceCharacteristics() {
		return offerInstanceCharacteristics;
	}

	public void addOfferInstanceCharacteristic(CharacterInstanceDTO offerInstanceCharacteristic) {
		if(null==offerInstanceCharacteristic){
			this.offerInstanceCharacteristics.add(offerInstanceCharacteristic);
		}		
	}

	public Set<ToBeOfferInstanceProductDTO> getProducts() {
		return products;
	}

	public void addProduct(ToBeProductDTO product,TimePeriod validPeriod) {
		if(null!=product){
			ToBeOfferInstanceProductDTO rel=new ToBeOfferInstanceProductDTO();
			rel.setToBeOfferInstanceDTO(this);
			rel.setToBeProductDTO(product);
			rel.setValidPeriod(validPeriod);
			this.products.add(rel);
		}		
	}
	
	public Set<NewSubscriberDTO> getNewSubscribers() {
		return newSubscribers;
	}

	public void addNewSubscriber(NewSubscriberDTO product) {
		if(null!=product){
			newSubscribers.add(product);
		}		
	}	

	public Set<ToBePricePlanInstanceDTO> getPricePlanInstances() {
		return pricePlanInstances;
	}

	public void addPricePlanInstance(ToBePricePlanInstanceDTO pricePlanInstance) {
		if(null!=pricePlanInstance){
			this.pricePlanInstances.add(pricePlanInstance);
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TimePeriod getValidPeriod() {
		return validPeriod;
	}

	public void setValidPeriod(TimePeriod validPeriod) {
		this.validPeriod = validPeriod;
	}

}
