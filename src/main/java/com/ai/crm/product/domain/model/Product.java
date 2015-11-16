package com.ai.crm.product.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.ai.common.basetype.TimePeriod;
import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class Product extends SpecInstanceEntity{
	private long customerId;
	private long userId;
	private Set<ProductBarReason> barReasons=new HashSet<ProductBarReason>();
	@JsonIgnore
	private Set<OfferInstanceProductRel> participantOfferInstances=new LinkedHashSet<OfferInstanceProductRel>();
	private Set<ProductPriceRel> assignedPrices=new HashSet<ProductPriceRel>();
	private long productSpecificationId;
	private String serialNumber;
	@OneToMany(mappedBy="specInstanceEntity",fetch=FetchType.LAZY)
	private Set<SpecInstanceEntityCharacter> characterInstances=new LinkedHashSet<SpecInstanceEntityCharacter>();
	
	@Override
	public  Set<SpecInstanceEntityCharacter> getCharacteristics(){
		return this.characterInstances;
	}
	
	@Override
	public void addCharacteristic(SpecInstanceEntityCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			character.setOwnerInstance(this);
		}
	}
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

	
	public Set<OfferInstanceProductRel> getParticipantOfferInstances() {
		return participantOfferInstances;
	}

	
	public Set<ProductPriceRel> getAssignedPrices() {
		return assignedPrices;
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
