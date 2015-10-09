package com.ai.upc.productoffering.domain.model.interaces;

import java.util.Set;

public interface IComponentOffer extends IProductOffering {
	Set<IOfferProductLineRelation> getProductLines();
	void addProductLine(IOfferProductLineRelation offerProductLineOption);
	Set<IOfferProductSpecificationRelation> getProductSpecs();
	void addProductSpec(IOfferProductSpecificationRelation offerProductSpecificationOption);
}
