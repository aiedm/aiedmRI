package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.product.domain.model.interfaces.IProductPriceRel;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
		@Type(value = IToBeProductPriceRel.class, name = "ToBeProductPriceRel")
	    })
public interface IToBeProductPriceRel extends IProductPriceRel {
	IProductPriceRel getAsIsProductPriceRel();
	void setAsIsProductPriceRel(IProductPriceRel productPriceRel);
}
