package com.ai.crm.customerorder.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.rootentity.impl.InstanceEntity;
import com.ai.crm.common.rootentity.interfaces.IInstanceEntityCharacteristic;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPrice;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
public class OrderPrice extends InstanceEntity implements IOrderPrice {
	private long pricePlanId;
	private long priceValue;
	private int payState;
	private String discountReason;
	private long pricePlanInstanceId;
	private long roleId;
	@JsonIgnore
	private IProductOrderItem productOrder;
	@JsonIgnore
	private IOfferOrderItem offerOrder;
	
	@Override
	public boolean hasCharacteristic() {
		return true;
	}
	
	@Override
	public long getPricePlanId() {
		return this.pricePlanId;
	}

	@Override
	public void setPricePlanId(long pricePlanId) {
		this.pricePlanId=pricePlanId;
	}

	@Override
	public long getPriceValue() {
		return this.priceValue;
	}

	@Override
	public void setPriceValue(long priceValue) {
		this.priceValue=priceValue;
	}

	@Override
	public int getPayState() {
		return this.payState;
	}

	@Override
	public void unPaid() {
		this.payState=IOrderPrice.PriceState.UNPAID.getValue();
	}

	@Override
	public void paid() {
		this.payState=IOrderPrice.PriceState.PAID.getValue();
	}

	@Override
	public String getDiscountReason() {
		// TODO Auto-generated method stub
		return this.discountReason;
	}

	@Override
	public void setDiscountReason(String discountReason) {
		this.discountReason=discountReason;
	}

	@Override
	public long getPricePlanInstanceId() {
		return this.pricePlanInstanceId;
	}

	@Override
	public void setPricePlanbInstanceId(long pricePlanInstanceId) {
		this.pricePlanInstanceId=pricePlanInstanceId;
	}

	@Override
	public IProductOrderItem getProductOrder() {
		return this.productOrder;
	}

	@Override
	public void setProductOrder(IProductOrderItem productOrder) {
		this.productOrder=productOrder;
	}

	@Override
	public IOfferOrderItem getOfferOrder() {
		return this.offerOrder;
	}

	@Override
	public void setOfferOrder(IOfferOrderItem offerOrder) {
		this.offerOrder= offerOrder;
	}

	@Override
	public Set<IInstanceEntityCharacteristic> getPriceCharacters() {
		return this.getCharacteristics();
	}

	@Override
	public void addPriceCharacter(IInstanceEntityCharacteristic priceCharacteristic) {
		this.addCharacteristic(priceCharacteristic);		
	}

	@Override
	public long getRoleId() {
		return this.roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		this.roleId=roleId;
	}

}
