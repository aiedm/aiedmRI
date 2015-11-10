package com.ai.crm.product.domain.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.SpecificationInstanceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class Product extends SpecificationInstanceEntity{
	private long customerId;
	private long userId;
	private Set<ProductBarReason> barReasons=new HashSet<ProductBarReason>();
	@JsonIgnore
	private Set<OfferInstance> participantOfferInstances=new HashSet<OfferInstance>();
	private Set<ProductPriceRel> assignedPrices=new HashSet<ProductPriceRel>();
	private long productSpecificationId;
	private String serialNumber;

	public Product() {
	}

	
	public Set<ProductBarReason> getBarReasons() {
		return barReasons;
	}

	
	public void addBarReason(ProductBarReason productBarReason) {
		if (null!=productBarReason){
			barReasons.add(productBarReason);
			if (null==productBarReason.getProduct()){
				productBarReason.setProduct(this);
			}
		}

	}

	
	public Set<OfferInstance> getParticipantOfferInstances() {
		return participantOfferInstances;
	}

	
	public void addToOfferInstance(OfferInstance offerInstance) {
		if (null!=offerInstance){
			participantOfferInstances.add(offerInstance);
			Set<Product> offerProducts=offerInstance.getProducts();
			if(!offerProducts.contains(this)){
				offerInstance.addProduct(this);
			}
		}

	}

	
	public Set<ProductPriceRel> getAssignedPrices() {
		return assignedPrices;
	}

	
	public void assignPrice(ProductPriceRel productPriceRel) {
		if (null!=productPriceRel){
			assignedPrices.add(productPriceRel);
			if (null==productPriceRel.getProduct()){
				productPriceRel.setProduct(this);
			}
		}

	}

	
	public long getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(long customerId) {
		this.customerId=customerId;		
	}

	
	public long getUserId() {
		return userId;
	}

	
	public void setUserId(long userId) {
		this.userId=userId;
	}

	
	public long getProductSpecificationId() {
		return productSpecificationId;
	}

	
	public void setProductSpecificationId(long productSpecificationId) {
		this.productSpecificationId=productSpecificationId;
	}

	
	public String getSerialNumber() {
		return this.serialNumber;
	}

	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber=serialNumber;
	}
}
