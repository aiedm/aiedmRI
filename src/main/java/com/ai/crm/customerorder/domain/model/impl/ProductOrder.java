package com.ai.crm.customerorder.domain.model.impl;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.impl.BusinessInteractionItem;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderCharacteristic;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
@Component
public class ProductOrder extends BusinessInteractionItem implements IProductOrder {
	private IOfferOrder offerOrder;
	private long productOrderId;
	private ICustomerOrder customerOrder;
	private IToBeProduct toBeProduct;
	private ProductOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductOrder(ICustomerOrder customerOrder) {
		super(customerOrder);
		this.setCustomerOrder(customerOrder);
	}	
	
	public ProductOrder(IOfferOrder offerOrder) {
		this.setOfferOrder(offerOrder);
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
	public Set<IProductOrderCharacteristic> getProductOrderCharacteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProductOrderCharacteristic(
			IProductOrderCharacteristic productOrderCharacteristic) {
		// TODO Auto-generated method stub
	}

	@Override
	public long getBusinessInteractionSpecificationId() {
		// TODO Auto-generated method stub
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
}
