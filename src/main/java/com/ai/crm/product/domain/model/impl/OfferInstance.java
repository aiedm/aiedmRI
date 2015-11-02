package com.ai.crm.product.domain.model.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.impl.SpecificationInstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IProduct;
@Component
public class OfferInstance extends SpecificationInstanceEntity implements IOfferInstance {
	private long offerInstanceId;
	private Set<IProduct> products=new HashSet<IProduct>();
	private Set<IPricePlanInstance> prices=new LinkedHashSet<IPricePlanInstance>();
	private long customerId;
	private long productOfferingId;
	
	public OfferInstance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getOfferInstanceId() {
		return offerInstanceId;
	}

	@Override
	public void setOfferInstanceId(long offerInstanceId) {
		this.offerInstanceId=offerInstanceId;

	}

	@Override
	public Set<IProduct> getProducts() {
		return products;
	}

	@Override
	public void addProduct(IProduct product) {
		if (null!=product){
			products.add(product);
			Set<IOfferInstance> participantOfferInstances=product.getParticipantOfferInstances();
			if (!participantOfferInstances.contains(this)){
				product.addToOfferInstance(this);
			}
		}
	}

	@Override
	public Set<IPricePlanInstance> getPricePlanInstances() {
		return prices;
	}

	@Override
	public void addPricePlanInstance(IPricePlanInstance pricePlanInstance) {
		if (null!=pricePlanInstance){
			prices.add(pricePlanInstance);
			if (null==pricePlanInstance.getOfferInstance()){
				pricePlanInstance.setOfferInstance(this);
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
	public long getProductOfferingId() {
		return productOfferingId;
	}

	@Override
	public void setProductOfferingId(long productOfferingId) {
		this.productOfferingId=productOfferingId;
	}

	@Override
	public Set<IInstanceEntityCharacter> getOfferInstanceCharacters() {
		return this.getCharacteristics();
	}

	@Override
	public void addOfferInstanceCharacter(IInstanceEntityCharacter offerInstanceCharacter) {
		if(null!=offerInstanceCharacter){
			this.addCharacteristic(offerInstanceCharacter);
		}
	}

}
