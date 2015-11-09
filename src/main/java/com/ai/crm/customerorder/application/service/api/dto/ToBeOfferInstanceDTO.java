package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

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
	private Set<CharacterInstanceDTO> offerInstanceCharacteristics = new LinkedHashSet<CharacterInstanceDTO>();	
	private Set<ToBePricePlanInstanceDTO> pricePlanInstances = new LinkedHashSet<ToBePricePlanInstanceDTO>();
	
	private Set<ToBeProductDTO> products = new LinkedHashSet<ToBeProductDTO>();

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

	public Set<ToBeProductDTO> getProducts() {
		return products;
	}

	public void addProduct(ToBeProductDTO product) {
		if(null!=product){
			this.products.add(product);
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

}
