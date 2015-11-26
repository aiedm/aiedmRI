package com.ai.crm.customerorder.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.AsIsProduct;
import com.ai.crm.product.domain.model.Product;
@Entity
@Table(name="ORD_TOBE_PRODUCT")
public class ToBeProduct extends Product{
	@OneToOne
	private AsIsProduct asIsProduct;
	
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<ToBeProductBarReason> barReasons=new HashSet<ToBeProductBarReason>();
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<ToBeOfferInstanceProductRel> participantOfferInstances=new LinkedHashSet<ToBeOfferInstanceProductRel>();
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<ToBeProductPriceRel> assignedPrices=new LinkedHashSet<ToBeProductPriceRel>();
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<ToBeProductCharacter> characterInstances=new LinkedHashSet<ToBeProductCharacter>();
	
	public  Set<ToBeProductCharacter> getProductCharacters(){
		return this.characterInstances;
	}
	
	public void addProductCharacter(ToBeProductCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
		}
	}
	
	public Set<ToBeProductBarReason> getBarReasons() {
		return barReasons;
	}

	
	public void addBarReason(ToBeProductBarReason productBarReason) {
		if (null!=productBarReason){
			barReasons.add(productBarReason);
			if (null==productBarReason.getProduct()){
				productBarReason.setProduct(this);
			}
		}

	}

	
	public Set<ToBeOfferInstanceProductRel> getParticipantOfferInstances() {
		return participantOfferInstances;
	}

	
	public Set<ToBeProductPriceRel> getAssignedPrices() {
		return assignedPrices;
	}
	
	public ToBeProduct() {
	}

	
	public AsIsProduct getAsIsProduct() {
		return asIsProduct;
	}

	
	public void setAsIsProduct(AsIsProduct product) {
		this.asIsProduct=product;
	}

}
