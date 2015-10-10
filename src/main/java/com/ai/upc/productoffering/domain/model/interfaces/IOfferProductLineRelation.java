package com.ai.upc.productoffering.domain.model.interfaces;

import com.ai.common.basetype.interfaces.IQuantity;
import com.ai.common.basetype.interfaces.IQuantityRange;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
import com.ai.upc.productspecification.domian.model.interfaces.IProductLine;

public interface IOfferProductLineRelation extends ISpecificationEntity {
	IProductOffering getOffer();
	void setOffer(IProductOffering offer);
	IProductLine getProductLine();
	void setProductLine(IProductLine productLine);
	IQuantityRange getProductLineQuantityRange();
	void setProductLineQuantityRange(IQuantityRange productLineQuantityRange);
	IQuantity getDefaultQuantity();
	void setDefaultQuantity(IQuantity defaultQuantity);
}
