package com.ai.crm.customerorder.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.basetype.TimePeriod;
import com.ai.crm.product.domain.model.AsIsPricePlanInstance;
import com.ai.crm.product.domain.model.PricePlanInstance;
@Entity
@Table(name="ORD_TOBE_PRICE_INS")
public class ToBePricePlanInstance extends PricePlanInstance{
	@OneToOne
	private AsIsPricePlanInstance asIsPricePlanInstance;
	
	@ManyToOne
	private ToBeOfferInstance offerInstance;
	
	private int action;
	
	@OneToMany(mappedBy="price",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<ToBeProductPriceRel> assignedTo=new LinkedHashSet<ToBeProductPriceRel>();
	
	@OneToMany(mappedBy="pricePlanInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<ToBePricePlanInstanceCharacter> characterInstances=new LinkedHashSet<ToBePricePlanInstanceCharacter>();

	public  Set<ToBePricePlanInstanceCharacter> getPricePlanInstanceCharacters(){
		return this.characterInstances;
	}
	
	public void addPricePlanInstanceCharacter(ToBePricePlanInstanceCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			if (null==character.getPricePlanInstance()){
				character.setPricePlanInstance(this);
			}
			super.addCharacteristic(character);
		}
	}
	
	public ToBeOfferInstance getOfferInstance() {
		return offerInstance;
	}

	
	public void setOfferInstance(ToBeOfferInstance offerInstance) {
		this.offerInstance=offerInstance;
	}

	
	public Set<ToBeProductPriceRel> getAssignedTo() {
		return assignedTo;
	}
	
	public void addProductPriceRel(ToBeProductPriceRel productPriceRel){
		if (null!=productPriceRel){
			assignedTo.add(productPriceRel);
			if (null==productPriceRel.getPricePlanInstance()){
				productPriceRel.setPricePlanInstance(this);
			}
		}
	}
	
	
	public void assignTo(ToBeProduct product,TimePeriod validPeriod) {
		if(null!=product){
			ToBeProductPriceRel productPriceRel = new ToBeProductPriceRel();
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
	
	public void unAssignTo(ToBeProduct product) {
		if(null!=product){
			ToBeProductPriceRel productPriceRel= new ToBeProductPriceRel();
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

	public AsIsPricePlanInstance getAsIsPricePlanInstance() {
		return asIsPricePlanInstance;
	}

	public void setAsIsPricePlanInstance(AsIsPricePlanInstance asIsPricePlanInstance) {
		this.asIsPricePlanInstance = asIsPricePlanInstance;
	}

	public int getAction() {
		return action;
	}
	

	public void setAction(int action) {
		this.action = action;
	}
	
}
