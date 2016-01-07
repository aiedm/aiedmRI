package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.basetype.TimePeriod;
@Entity
@Table(name="PD_OFFER_INS")
public class AsIsOfferInstance extends OfferInstance{
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AsIsOfferInstanceProductRel> includedProducts=new LinkedHashSet<AsIsOfferInstanceProductRel>();
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AsIsPricePlanInstance> prices=new LinkedHashSet<AsIsPricePlanInstance>();
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AsIsOfferInstanceCharacter> characterInstances=new LinkedHashSet<AsIsOfferInstanceCharacter>();
	public  Set<AsIsOfferInstanceCharacter> getOfferInstanceCharacters(){
		return this.characterInstances;
	}
	
	public void addOfferInstanceCharacter(AsIsOfferInstanceCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
		}
	}	
	
	public Set<AsIsOfferInstanceProductRel> getProducts() {
		return includedProducts;
	}
	
	public void addProduct(AsIsProduct product,TimePeriod validPeriod) {
		if (null!=product){
			AsIsOfferInstanceProductRel offerInstanceProductRel=new AsIsOfferInstanceProductRel();
			offerInstanceProductRel.setOfferInstance(this);
			offerInstanceProductRel.setProduct(product);
			offerInstanceProductRel.setValidPeriod(validPeriod);
			if(!includedProducts.contains(offerInstanceProductRel)){
				includedProducts.add(offerInstanceProductRel);
			}
			if (!product.getParticipantOfferInstances().contains(this)){
				product.getParticipantOfferInstances().add(offerInstanceProductRel);
			}
		}
	}
	
	public void removeProduct(AsIsProduct product) {
		if (null!=product){
			AsIsOfferInstanceProductRel offerInstanceProductRel=new AsIsOfferInstanceProductRel();
			offerInstanceProductRel.setOfferInstance(this);
			offerInstanceProductRel.setProduct(product);
			if(includedProducts.contains(offerInstanceProductRel)){
				includedProducts.remove(offerInstanceProductRel);
			}
			if (product.getParticipantOfferInstances().contains(this)){
				product.getParticipantOfferInstances().remove(offerInstanceProductRel);
			}
		}
	}	

	
	public Set<AsIsPricePlanInstance> getPricePlanInstances() {
		return prices;
	}

	
	public void addPricePlanInstance(AsIsPricePlanInstance pricePlanInstance) {
		if (null!=pricePlanInstance){
			prices.add(pricePlanInstance);
			if (null==pricePlanInstance.getOfferInstance()){
				pricePlanInstance.setOfferInstance(this);
			}
		}

	}	
}
