package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.basetype.TimePeriod;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PD_PRICE_INS")
public class AsIsPricePlanInstance extends PricePlanInstance {
	@ManyToOne
	private AsIsOfferInstance offerInstance;
	
	@OneToMany(mappedBy="price",fetch=FetchType.LAZY)
	private Set<AsIsProductPriceRel> assignedTo=new LinkedHashSet<AsIsProductPriceRel>();
	
	@OneToMany(mappedBy="pricePlanInstance",fetch=FetchType.LAZY)
	private Set<AsIsPricePlanInstanceCharacter> characterInstances=new LinkedHashSet<AsIsPricePlanInstanceCharacter>();

	public  Set<AsIsPricePlanInstanceCharacter> getPricePlanInstanceCharacters(){
		return this.characterInstances;
	}
	
	public void addPricePlanInstanceCharacter(AsIsPricePlanInstanceCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
		}
	}
	
	public AsIsOfferInstance getOfferInstance() {
		return offerInstance;
	}

	
	public void setOfferInstance(AsIsOfferInstance offerInstance) {
		this.offerInstance=offerInstance;
	}

	
	public Set<AsIsProductPriceRel> getAssignedTo() {
		return assignedTo;
	}
	
	public void assignTo(AsIsProduct product,TimePeriod validPeriod) {
		if(null!=product){
			AsIsProductPriceRel productPriceRel = new AsIsProductPriceRel();
			productPriceRel.setPricePlanInstance(this);
			productPriceRel.setProduct(product);
			productPriceRel.setValidPeriod(validPeriod);
			if(!assignedTo.contains(productPriceRel)){
				assignedTo.add(productPriceRel);
			}
			
			if(!product.getAssignedPrices().contains(productPriceRel)){
				product.getAssignedPrices().add(productPriceRel);
			}
		}
		
	}
	
	public void unAssignTo(AsIsProduct product) {
		if(null!=product){
			AsIsProductPriceRel productPriceRel= new AsIsProductPriceRel();
			productPriceRel.setPricePlanInstance(this);
			productPriceRel.setProduct(product);
			if(assignedTo.contains(productPriceRel)){
				assignedTo.remove(productPriceRel);
			}
			if(product.getAssignedPrices().contains(productPriceRel)){
				product.getAssignedPrices().remove(productPriceRel);
			}			
		}
		
	}

}
