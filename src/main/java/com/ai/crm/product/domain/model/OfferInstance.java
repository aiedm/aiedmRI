package com.ai.crm.product.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.SpecificationInstanceEntity;
@Component
public class OfferInstance extends SpecificationInstanceEntity{
	private Set<Product> products=new LinkedHashSet<Product>();
	private Set<PricePlanInstance> prices=new LinkedHashSet<PricePlanInstance>();
	private long customerId;
	private long productOfferingId;
	
	public OfferInstance() {
		// TODO Auto-generated constructor stub
	}

	
	public Set<Product> getProducts() {
		return products;
	}

	
	public void addProduct(Product product) {
		if (null!=product){
			products.add(product);
			Set<OfferInstance> participantOfferInstances=product.getParticipantOfferInstances();
			if (!participantOfferInstances.contains(this)){
				product.addToOfferInstance(this);
			}
		}
	}

	
	public Set<PricePlanInstance> getPricePlanInstances() {
		return prices;
	}

	
	public void addPricePlanInstance(PricePlanInstance pricePlanInstance) {
		if (null!=pricePlanInstance){
			prices.add(pricePlanInstance);
			if (null==pricePlanInstance.getOfferInstance()){
				pricePlanInstance.setOfferInstance(this);
			}
		}

	}

	
	public long getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(long customerId) {
		this.customerId=customerId;
	}

	
	public long getProductOfferingId() {
		return productOfferingId;
	}

	
	public void setProductOfferingId(long productOfferingId) {
		this.productOfferingId=productOfferingId;
	}

}
