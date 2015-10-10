package com.ai.upc.productoffering.domain.model.interfaces;

import com.ai.common.basetype.interfaces.IQuantity;
import com.ai.common.basetype.interfaces.IQuantityRange;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
import com.ai.upc.productspecification.domian.model.interfaces.IProductSpecification;

public interface IOfferProductSpecificationRelation extends ISpecificationEntity {
	IComponentOffer getOffer();
	void setOffer(IComponentOffer offer);
	IProductSpecification getProductSpecification();
	void setProductSpecification(IProductSpecification productSpecification);
	IQuantityRange getQuantityRange();
	void setQuantityRange(IQuantityRange quantityRange);
	IQuantity getDefaultQuantity();
	void setDefaultQuantity(IQuantity defaultQuantity);
	IOfferProductLineRelation getBelongToProductLine();
	void setBelongToProductLine(IOfferProductLineRelation offerProductLineOption);
	IOfferRole getGroupedOfferRole();
	void setGroupedOfferRole(IOfferRole offerRole);
}
