package com.ai.upc.productoffering.domain.model.interaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public interface IProductOffering extends ISpecificationEntity {
	long getOfferId();
	void setOfferId(long offerId);
	Set<IOfferRole> getRoles();
	void addRole(IOfferRole newRole);
	Set<IOfferPriceTarget> getOfferPriceTargets();
	void addOfferPriceTarget(IOfferPriceTarget offerPriceTarget);
	Set<IOfferSubscribedEvent> getSubscribedEvent();
	void addSubscribedEvent(IOfferSubscribedEvent offerSubscribedEvent);
}
