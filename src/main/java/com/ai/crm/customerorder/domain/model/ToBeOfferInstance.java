package com.ai.crm.customerorder.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.basetype.TimePeriod;
import com.ai.crm.product.domain.model.AsIsOfferInstance;
import com.ai.crm.product.domain.model.OfferInstance;
@Entity
@Table(name="ORD_TOBE_OFFER_INS")
public class ToBeOfferInstance extends OfferInstance{
	@OneToOne
	private AsIsOfferInstance asIsOfferInstance;
	
	@OneToMany(mappedBy="offerInstance",fetch=FetchType.LAZY)
	private Set<ToBeOfferInstanceProductRel> includedProducts=new LinkedHashSet<ToBeOfferInstanceProductRel>();
	
	@OneToMany(mappedBy="offerInstance",fetch=FetchType.LAZY)
	private Set<ToBePricePlanInstance> prices=new LinkedHashSet<ToBePricePlanInstance>();
	
	@OneToMany(mappedBy="offerInstance",fetch=FetchType.LAZY)
	private Set<ToBeOfferInstanceCharacter> characterInstances=new LinkedHashSet<ToBeOfferInstanceCharacter>();
	public  Set<ToBeOfferInstanceCharacter> getOfferInstanceCharacters(){
		return this.characterInstances;
	}
	
	public void addOfferInstanceCharacter(ToBeOfferInstanceCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
		}
	}	
	
	public Set<ToBeOfferInstanceProductRel> getProducts() {
		return includedProducts;
	}

	
	public void addProduct(ToBeProduct product,TimePeriod validPeriod) {
		if (null!=product){
			ToBeOfferInstanceProductRel offerInstanceProductRel=new ToBeOfferInstanceProductRel();
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
	
	public void removeProduct(ToBeProduct product) {
		if (null!=product){
			ToBeOfferInstanceProductRel offerInstanceProductRel=new ToBeOfferInstanceProductRel();
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

	
	public Set<ToBePricePlanInstance> getPricePlanInstances() {
		return prices;
	}

	
	public void addPricePlanInstance(ToBePricePlanInstance pricePlanInstance) {
		if (null!=pricePlanInstance){
			prices.add(pricePlanInstance);
			if (null==pricePlanInstance.getOfferInstance()){
				pricePlanInstance.setOfferInstance(this);
			}
		}

	}		
	public ToBeOfferInstance() {
	}

	public AsIsOfferInstance getAsIsOfferInstance() {
		return asIsOfferInstance;
	}

	public void setAsIsOfferInstance(AsIsOfferInstance offerInstance) {
		this.asIsOfferInstance=offerInstance;
	}

}
