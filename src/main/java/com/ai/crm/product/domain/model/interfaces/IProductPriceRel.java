package com.ai.crm.product.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;
import com.ai.crm.product.domain.model.impl.ProductPriceRel;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
		@Type(value = ProductPriceRel.class, name = "ProductPriceRel")
	    })
public interface IProductPriceRel extends IInstanceEntity {
	IProduct getProduct();
	void setProduct(IProduct product);
	IPricePlanInstance getPricePlanInstance();
	void setPricePlanInstance(IPricePlanInstance price);
}
