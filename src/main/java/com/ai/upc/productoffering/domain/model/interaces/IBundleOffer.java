package com.ai.upc.productoffering.domain.model.interaces;

import java.util.Set;

public interface IBundleOffer extends IProductOffering {
	Set<IBundleOfferOption> getChildOffers();
	void addChildOffer(IBundleOfferOption childOffer);
}
