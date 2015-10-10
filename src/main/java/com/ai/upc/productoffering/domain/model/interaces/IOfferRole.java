package com.ai.upc.productoffering.domain.model.interaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
import com.ai.upc.productspecification.domian.model.interfaces.IProductSpecification;

public interface IOfferRole extends ISpecificationEntity {
	long getRoleId();
	void setRoleId(long roleId);
	Set<IProductOffering> getChildOffers();
	void addChildOffer(IProductOffering offer);
	Set<IProductSpecification> getChildProductSpecs();
	void addChildProductSpec(IProductSpecification productSpec);
	
}
