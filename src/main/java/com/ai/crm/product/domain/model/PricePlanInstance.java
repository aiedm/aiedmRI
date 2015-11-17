package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ai.common.basetype.TimePeriod;
import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PricePlanInstance extends SpecInstanceEntity {
	public enum PriceState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		PAID(3),
		ASSIGNED(5),
		COMPLETED(6);
		private int value;  

	    private PriceState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}
	@ManyToOne
	private OfferInstance offerInstance;
	@OneToMany(mappedBy="price",fetch=FetchType.LAZY)
	private Set<ProductPriceRel> assignedTo=new LinkedHashSet<ProductPriceRel>();
	private long pricePlanId;
	private long priceValue;
	private int payState;
	private String discountReason;
	private long roleId;
	@OneToMany(mappedBy="pricePlanInstance",fetch=FetchType.LAZY)
	private Set<PricePlanInstanceCharacter> characterInstances=new LinkedHashSet<PricePlanInstanceCharacter>();
	@Id
	private long id;	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public  Set<PricePlanInstanceCharacter> getPricePlanInstanceCharacters(){
		return this.characterInstances;
	}
	
	public void addPricePlanInstanceCharacter(PricePlanInstanceCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
		}
	}
	public PricePlanInstance() {
	}

	
	public OfferInstance getOfferInstance() {
		return offerInstance;
	}

	
	public void setOfferInstance(OfferInstance offerInstance) {
		this.offerInstance=offerInstance;
	}

	
	public Set<ProductPriceRel> getAssignedTo() {
		return assignedTo;
	}

	
	public void assignTo(Product product,TimePeriod validPeriod) {
		if(null!=product){
			ProductPriceRel productPriceRel=new ProductPriceRel();
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
	
	public void unAssignTo(Product product) {
		if(null!=product){
			ProductPriceRel productPriceRel=new ProductPriceRel();
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

	
	public long getPricePlanId() {
		return pricePlanId;
	}

	
	public void setPricePlanId(long pricePlanId) {
		this.pricePlanId=pricePlanId;
	}
	
	
	public long getPriceValue() {
		return this.priceValue;
	}

	
	public void setPriceValue(long priceValue) {
		this.priceValue=priceValue;
	}	

	
	public int getPayState() {
		return this.payState;
	}

	
	public void unPaid() {
		this.payState=PricePlanInstance.PriceState.SUBMITTED.getValue();
	}

	
	public void paid() {
		this.payState=PricePlanInstance.PriceState.PAID.getValue();
	}

	
	public String getDiscountReason() {
		return this.discountReason;
	}

	
	public void setDiscountReason(String discountReason) {
		this.discountReason=discountReason;
	}
	
	public long getRoleId() {
		return this.roleId;
	}

	
	public void setRoleId(long roleId) {
		this.roleId=roleId;
	}
}
