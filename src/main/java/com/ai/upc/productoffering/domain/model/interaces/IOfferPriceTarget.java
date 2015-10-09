package com.ai.upc.productoffering.domain.model.interaces;

import java.util.Set;

import com.ai.common.rootentity.interfaces.ISpecificationEntity;

public interface IOfferPriceTarget extends ISpecificationEntity {
	IProductOffering getOffer();
	void setOffer(IProductOffering offer);
	Set<IOfferPricePlanRelation> getPricePlans();
	void addPricePlan(IOfferPricePlanRelation offerPricePlanRelation);
	Set<IOfferProductSpecificationRelation> getProductSpecs();
	void addProductSpec(IOfferProductSpecificationRelation offerProductSpecificationRelation);
}
