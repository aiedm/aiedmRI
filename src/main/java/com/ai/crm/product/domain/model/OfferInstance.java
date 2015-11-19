package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.basetype.TimePeriod;
import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
@Entity
@Table(name="PD_OFFER_INS")
public class OfferInstance extends SpecInstanceEntity{
	@OneToMany(mappedBy="offerInstance",fetch=FetchType.LAZY)
	private Set<OfferInstanceProductRel> includedProducts=new LinkedHashSet<OfferInstanceProductRel>();
	@OneToMany(mappedBy="offerInstance",fetch=FetchType.LAZY)
	private Set<PricePlanInstance> prices=new LinkedHashSet<PricePlanInstance>();
	private long customerId;
	private long productOfferingId;
	@OneToMany(mappedBy="offerInstance",fetch=FetchType.LAZY)
	private Set<OfferInstanceCharacter> characterInstances=new LinkedHashSet<OfferInstanceCharacter>();
	
	@Id
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public  Set<OfferInstanceCharacter> getOfferInstanceCharacters(){
		return this.characterInstances;
	}
	
	public void addOfferInstanceCharacter(OfferInstanceCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
		}
	}	
	public OfferInstance() {
		// TODO Auto-generated constructor stub
	}

	
	public Set<OfferInstanceProductRel> getProducts() {
		return includedProducts;
	}

	
	public void addProduct(Product product,TimePeriod validPeriod) {
		if (null!=product){
			OfferInstanceProductRel offerInstanceProductRel=new OfferInstanceProductRel();
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
	
	public void removeProduct(Product product) {
		if (null!=product){
			OfferInstanceProductRel offerInstanceProductRel=new OfferInstanceProductRel();
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

	
	public Set<PricePlanInstance> getPricePlanInstances() {
		return prices;
	}

	
	public void addPricePlanInstance(PricePlanInstance pricePlanInstance) {
		if (null!=pricePlanInstance){
			prices.add(pricePlanInstance);
			if (null==pricePlanInstance.getOfferInstance()){
				pricePlanInstance.setOfferInstance(this);
			}
		}

	}

	
	public long getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(long customerId) {
		this.customerId=customerId;
	}

	
	public long getProductOfferingId() {
		return productOfferingId;
	}

	
	public void setProductOfferingId(long productOfferingId) {
		this.productOfferingId=productOfferingId;
	}

}
