package com.ai.upc.productoffering.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
import com.ai.common.rootentity.domain.model.interfaces.ISubscribedEvent;

public interface IProductOffering extends ISpecificationEntity {
	long getOfferId();
	void setOfferId(long offerId);
	Set<IOfferRole> getRoles();
	void addRole(IOfferRole newRole);
	Set<IOfferPriceTarget> getOfferPriceTargets();
	void addOfferPriceTarget(IOfferPriceTarget offerPriceTarget);		
}
