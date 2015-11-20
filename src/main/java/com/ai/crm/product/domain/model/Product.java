package com.ai.crm.product.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;

@MappedSuperclass
public class Product extends SpecInstanceEntity{
	private long customerId;
	private long userId;
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<ProductBarReason> barReasons=new HashSet<ProductBarReason>();
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<OfferInstanceProductRel> participantOfferInstances=new LinkedHashSet<OfferInstanceProductRel>();
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<ProductPriceRel> assignedPrices=new HashSet<ProductPriceRel>();
	private long productSpecificationId;
	private String serialNumber;
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<ProductCharacter> characterInstances=new LinkedHashSet<ProductCharacter>();
		
	@Id
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public  Set<ProductCharacter> getProductCharacters(){
		return this.characterInstances;
	}
	
	public void addProductCharacter(ProductCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
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
