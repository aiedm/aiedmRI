package com.ai.upc.productoffering.domain.model;

import java.util.Set;

import com.ai.common.rootentity.domain.model.SpecificationEntity;

public class ProductOffering extends SpecificationEntity{

	public ProductOffering() {
		// TODO Auto-generated constructor stub
	}

	
	public long getOfferId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setOfferId(long offerId) {
		// TODO Auto-generated method stub

	}

	
	public Set<OfferRole> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addRole(OfferRole newRole) {
		// TODO Auto-generated method stub

	}

	
	public Set<OfferPriceTarget> getOfferPriceTargets() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addOfferPriceTarget(OfferPriceTarget offerPriceTarget) {
		// TODO Auto-generated method stub

	}

}
