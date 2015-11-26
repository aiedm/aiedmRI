package com.ai.crm.customerorder.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ai.crm.common.businessinteraction.domain.model.BusinessInteractionItemRel;

@Entity
public class OfferOrderItem extends CustomerOrderItem{
	public enum OfferOrderState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		CHARGE_ASSIGNED(9),
		COMPLETED(6),
		CLOSED(7),
		CANCLED(8);
		private int value;  

	    private OfferOrderState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}	
	@OneToOne(targetEntity=BusinessInteractionItemRel.class,mappedBy="businessInteractionItemA")
	@JoinColumn(name="BII_B")
	private OfferOrderItem replacedOfferOrderItem;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="RELAT_ENTITY_ID")
	private ToBeOfferInstance  toBeOfferInstance;
	
	@ManyToOne
	CustomerOrder customerOrder;
	
	protected OfferOrderItem() {
		
	}
	
	public OfferOrderItem(CustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
		customerOrder.addOfferOrder(this);
	}	

	public CustomerOrder getCustomerOrder() {
		return (CustomerOrder)super.getBusinessInteraction();
	}

	
	public void setCustomerOrder(CustomerOrder customerOrder) {
		super.setBusinessInteraction(customerOrder);	
	}


	
	public int getOfferOrderState() {
		return this.getBiiState();
	}

	
	public void setOfferOrderState(int offerOrderState) {
		this.setBiiState(offerOrderState);		
	}

	
	public OfferOrderItem getReplcedOfferOrderItem() {
		return replacedOfferOrderItem;
	}

	
	public void setReplcedOfferOrderItem(OfferOrderItem offerOrderItem) {
		replacedOfferOrderItem=offerOrderItem;
	}

	
	public long getOfferOrderId() {
		return super.getId();
	}

	
	public void setOfferOrderId(long offerOrderId) {
		super.setId(offerOrderId);
	}

	public ToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}

	public void setToBeOfferInstance(ToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}

}
