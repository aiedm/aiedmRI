package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.customerorder.domain.model.impl.ToBeOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = ToBeOfferInstance.class, name = "ToBeOfferInstance"),
	    })
public interface IToBeOfferInstance extends IOfferInstance {
	IOfferOrder getOfferOrder();
	void setOfferOrder(IOfferOrder offerOrder);
}
