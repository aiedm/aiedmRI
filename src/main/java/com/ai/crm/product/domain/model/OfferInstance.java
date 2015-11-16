package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.ai.common.basetype.TimePeriod;
import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
@Component
public class OfferInstance extends SpecInstanceEntity{
	
	private Set<OfferInstanceProductRel> includedProducts=new LinkedHashSet<OfferInstanceProductRel>();
	private Set<PricePlanInstance> prices=new LinkedHashSet<PricePlanInstance>();
	private long customerId;
	private long productOfferingId;
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
