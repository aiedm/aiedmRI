package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.customerorder.domain.model.impl.ToBePricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = ToBePricePlanInstance.class, name = "ToBePricePlanInstance")
	    })
public interface IToBePricePlanInstance extends IPricePlanInstance{
	IPricePlanInstance getAsIsPricePlanInstance();
	void setAsIsPricePlanInstance(IPricePlanInstance pricePlanInstance);
}
