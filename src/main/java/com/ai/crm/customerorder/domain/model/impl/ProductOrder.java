package com.ai.crm.customerorder.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.impl.BusinessInteractionItem;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPrice;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderCharacteristicValue;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ProductOrder extends BusinessInteractionItem implements IProductOrder {
	@JsonIgnore
	private IOfferOrder offerOrder;
	
	private long productOrderId;
	
	@JsonIgnore
	private ICustomerOrder customerOrder;
	
	private IToBeProduct toBeProduct;
	private long productSpecificationId;
	private Set<IOrderPrice> prices=new HashSet<IOrderPrice>();
	private Set<IProductOrderCharacteristicValue> characteristicValues=new HashSet<IProductOrderCharacteristicValue>();
	private ProductOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductOrder(ICustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
		customerOrder.addProductOrder(this);
	}	
	
	public ProductOrder(IOfferOrder offerOrder) {
		this.setOfferOrder(offerOrder);
		offerOrder.addProductOrder(this);
	}	

	@Override
	public ICustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	@Override
	public IOfferOrder getOfferOrder() {
		return offerOrder;
	}

	@Override
	public long getProductOrderId() {
		return productOrderId;
	}

	@Override
	public Set<IProductOrderCharacteristicValue> getProductOrderCharacteristics() {
		return this.characteristicValues;
	}

	@Override
	public void addProductOrderCharacteristic(IProductOrderCharacteristicValue productOrderCharacteristic) {
		if (null!=productOrderCharacteristic){
			characteristicValues.add(productOrderCharacteristic);
			if (null==productOrderCharacteristic.getProductOrder()){
				productOrderCharacteristic.setProductOrder(this);
			}
		}
	}

	@Override
	public long getBusinessInteractionSpecificationId() {
		//TODO
		return 0;
	}

	@Override
	public void setCustomerOrder(ICustomerOrder customerOrder) {
		this.customerOrder=customerOrder;
		
	}

	@Override
	public void setOfferOrder(IOfferOrder offerOrder) {
		this.offerOrder=offerOrder;
		
	}

	@Override
	public void setProductOrderId(long productOrderId) {
		this.productOrderId=productOrderId;
		
	}

	@Override
	public int getProductOrderState() {
		return this.getBiiState();
	}

	@Override
	public void setProductOrderState(int productOrderState) {
		this.setBiiState(productOrderState);		
	}

	@Override
	public IToBeProduct getToBeProduct() {
		return toBeProduct;
	}

	@Override
	public void setToBeProduct(IToBeProduct toBeProduct) {
		this.toBeProduct=toBeProduct;
	}

	@Override
	public long getProductSpecificationId() {
		return this.productSpecificationId;
	}

	@Override
	public void setProductSpecificationId(long productSpecificationId) {
		this.productSpecificationId=productSpecificationId;
	}

	@Override
	public Set<IOrderPrice> getPrices() {
		return this.prices;
	}

	@Override
	public void addPrice(IOrderPrice orderPrice) {
		if(null!=orderPrice){
			prices.add(orderPrice);
			if (null==orderPrice.getOfferOrder()){
				orderPrice.setProductOrder(this);
			}
		}
	}
}
