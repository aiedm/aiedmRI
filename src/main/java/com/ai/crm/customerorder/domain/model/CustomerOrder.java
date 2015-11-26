package com.ai.crm.customerorder.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ai.crm.common.businessinteraction.domain.model.BusinessInteraction;
import com.ai.crm.common.businessinteraction.domain.model.BusinessInteractionItem;
import com.ai.crm.common.businessinteraction.domain.model.BusinessInteractionRel;

@Entity
//@DiscriminatorValue("1000")
@Access(AccessType.FIELD) 
public class CustomerOrder extends BusinessInteraction {
	public enum CustomerOrderState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		PAID(3),
		DELIVERING(4),
		DELIVERED(5),
		COMPLETED(6),
		CLOSED(7),
		CANCLED(8);
		private int value;  

	    private CustomerOrderState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}

	@OneToOne(targetEntity=BusinessInteractionRel.class,mappedBy="businessInteractionA")
	@JoinColumn(name="BI_B")
	private ShoppingCart shoppingCart;
	
	private CustomerOrder(){
		
	}
	
	
	public CustomerOrder( long biSpecId) {
		super(biSpecId);
	}

	
	public long getCustomerOrderId() {
		return super.getId();
	}

	
	public String getCustomerOrderCode() {
		return this.getCode();
	}

	
	public Set<ProductOrderItem> getProductOrders() {
		Set<ProductOrderItem> productOrders=new LinkedHashSet<ProductOrderItem>();
		Set<BusinessInteractionItem> items=super.getBusinessInteractionItems();
		if (items!=null&&items.size()>0) {
			for (BusinessInteractionItem businessInteractionItem : items) {
				if (businessInteractionItem instanceof ProductOrderItem){
					productOrders.add((ProductOrderItem)businessInteractionItem);
				}
			}
		}
		return productOrders;
	}

	
	public Set<OfferOrderItem> getOfferOrders() {
		Set<OfferOrderItem> offerOrders=new LinkedHashSet<OfferOrderItem>();
		Set<BusinessInteractionItem> items=super.getBusinessInteractionItems();
		if (items!=null&&items.size()>0) {
			for (BusinessInteractionItem businessInteractionItem : items) {
				if (businessInteractionItem instanceof OfferOrderItem){
					offerOrders.add((OfferOrderItem)businessInteractionItem);
				}
			}
		}
		return offerOrders;
	}

	
	public void addOfferOrder(OfferOrderItem offerOrder) {
		if (null!=offerOrder){
			this.addBusinessInteractionItem(offerOrder);
		}
	}

	
	public void addProductOrder(ProductOrderItem productOrder) {
		if (null!=productOrder){
			this.addBusinessInteractionItem(productOrder);
		}
	}

	
	public void setCustomerOrderId(long customerOrderId) {
		super.setId(customerOrderId);
		
	}

	
	public void setCustomerOrderCode(String customerOrderCode) {
		this.setCode(customerOrderCode);
		
	}
	
	public int getOrderState(){
		return this.getBiState();
	}
	
	public void setOrderState(int orderState){
		this.setBiState(orderState);
	}

	
	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart=shoppingCart;
	}

}
