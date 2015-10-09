package com.ai.crm.product.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IProduct;
import com.ai.crm.product.domain.model.interfaces.IProductBarReason;

public class Product implements IProduct {
	private long productId;
	private long customerId;
	private long userId;
	private Set<IProductBarReason> barReasons=new HashSet<IProductBarReason>();
	private Set<IOfferInstance> participantOfferInstancess=new HashSet<IOfferInstance>();
	private Set<IPricePlanInstance> assignedPrices=new HashSet<IPricePlanInstance>();
	private long productSpecificationId;
	private String serialNumber;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getProductId() {
		return productId;
	}

	@Override
	public void setProductId(long productId) {
		this.productId=productId;
	}

	@Override
	public Set<IProductBarReason> getBarReasons() {
		return barReasons;
	}

	@Override
	public void addBarReason(IProductBarReason productBarReason) {
		if (null!=productBarReason){
			barReasons.add(productBarReason);
			if (null==productBarReason.getProduct()){
				productBarReason.setProduct(this);
			}
		}

	}

	@Override
	public Set<IOfferInstance> getParticipantOfferInstances() {
		return participantOfferInstancess;
	}

	@Override
	public void addToOfferInstance(IOfferInstance offerInstance) {
		if (null!=offerInstance){
			participantOfferInstancess.add(offerInstance);
			Set<IProduct> offerProducts=offerInstance.getProducts();
			if(!offerProducts.contains(this)){
				offerInstance.addProduct(this);
			}
		}

	}

	@Override
	public Set<IPricePlanInstance> getAssignedPrices() {
		return assignedPrices;
	}

	@Override
	public void assignPrice(IPricePlanInstance pricePlanInstance) {
		if (null!=pricePlanInstance){
			assignedPrices.add(pricePlanInstance);
			Set<IProduct> assignedTo=pricePlanInstance.getAssignedTo();
			if (!assignedTo.contains(this)){
				pricePlanInstance.assignTo(this);
			}
		}

	}

	@Override
	public long getCustomerId() {
		return customerId;
	}

	@Override
	public void setCustomerId(long customerId) {
		this.customerId=customerId;		
	}

	@Override
	public long getUserId() {
		return userId;
	}

	@Override
	public void setUserId(long userId) {
		this.userId=userId;
	}

	@Override
	public long getProductSpecificationId() {
		return productSpecificationId;
	}

	@Override
	public void setProductSpecificationId(long productSpecificationId) {
		this.productSpecificationId=productSpecificationId;
	}

	@Override
	public String getSerialNumber() {
		return this.serialNumber;
	}

	@Override
	public void setSerialNumber(String serialNumber) {
		this.serialNumber=serialNumber;
	}

}
