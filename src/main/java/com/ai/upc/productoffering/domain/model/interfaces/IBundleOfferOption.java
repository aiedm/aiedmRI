package com.ai.upc.productoffering.domain.model.interfaces;

import com.ai.common.basetype.interfaces.IQuantity;
import com.ai.common.basetype.interfaces.IQuantityRange;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public interface IBundleOfferOption extends ISpecificationEntity {
	IBundleOffer getParentOffer();
	void setParentOffer(IBundleOffer parentOffer);
	IProductOffering getChildOffer();
	void setChildOffer(IProductOffering childOffer);
	IOfferRole getGroupedOfferRole();
	void setGroupedOfferRole(IOfferRole offerRole);
	IQuantityRange getQuantityRange();
	void setQuantityRange(IQuantityRange quantityRange);
	IQuantity getDefaultQuantity();
	void setDefaultQuantity(IQuantity defaultQuantity);	
}
