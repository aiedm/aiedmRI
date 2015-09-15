package com.ai.crm.customerorder.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPrice;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPriceCharacteristicValue;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class OrderPrice implements IOrderPrice {
	private long pricePlanId;
	private long priceValue;
	private int payState;
	private String discountReason;
	private long pricePlanInstanceId;
	Set<IOrderPriceCharacteristicValue> priceCharacteristicValues=new HashSet<IOrderPriceCharacteristicValue>();
	@JsonIgnore
	private IProductOrder productOrder;
	@JsonIgnore
	private IOfferOrder offerOrder;
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
	public IProductOrder getProductOrder() {
		return this.productOrder;
	}

	@Override
	public void setProductOrder(IProductOrder productOrder) {
		this.productOrder=productOrder;
	}

	@Override
	public IOfferOrder getOfferOrder() {
		return this.offerOrder;
	}

	@Override
	public void setOfferOrder(IOfferOrder offerOrder) {
		this.offerOrder= offerOrder;
	}

	@Override
	public Set<IOrderPriceCharacteristicValue> getPriceCharacterValues() {
		// TODO Auto-generated method stub
		return this.priceCharacteristicValues;
	}

	@Override
	public void addPriceCharacterValue(IOrderPriceCharacteristicValue priceCharacteristicValue) {
		if (null!=priceCharacteristicValue){
			priceCharacteristicValues.add(priceCharacteristicValue);
			if (null==priceCharacteristicValue.getOrderPrice()){
				priceCharacteristicValue.setOrderPrice(this);
			}
		}
		
	}

}
