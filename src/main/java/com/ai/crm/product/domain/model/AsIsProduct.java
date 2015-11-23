package com.ai.crm.product.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PD_PRODUCT")
public class AsIsProduct extends Product{
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<AsIsProductBarReason> barReasons=new HashSet<AsIsProductBarReason>();
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<AsIsOfferInstanceProductRel> participantOfferInstances=new LinkedHashSet<AsIsOfferInstanceProductRel>();
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<AsIsProductPriceRel> assignedPrices=new HashSet<AsIsProductPriceRel>();
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private Set<AsIsProductCharacter> characterInstances=new LinkedHashSet<AsIsProductCharacter>();
	
	public  Set<AsIsProductCharacter> getProductCharacters(){
		return this.characterInstances;
	}
	
	public void addProductCharacter(AsIsProductCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
		}
	}
	
	public Set<AsIsProductBarReason> getBarReasons() {
		return barReasons;
	}

	
	public void addBarReason(AsIsProductBarReason productBarReason) {
		if (null!=productBarReason){
			barReasons.add(productBarReason);
			if (null==productBarReason.getProduct()){
				productBarReason.setProduct(this);
			}
		}

	}

	
	public Set<AsIsOfferInstanceProductRel> getParticipantOfferInstances() {
		return participantOfferInstances;
	}

	
	public Set<AsIsProductPriceRel> getAssignedPrices() {
		return assignedPrices;
	}
}
