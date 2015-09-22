package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;
import com.ai.crm.customerorder.domain.model.impl.OrderPriceCharacteristicValue;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = OrderPriceCharacteristicValue.class, name = "OrderPriceCharacteristicValue"),
    })
public interface IOrderPriceCharacteristicValue {
	ICharacteristicValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicValue value);
	IOrderPrice getOrderPrice();
	void setOrderPrice(IOrderPrice orderPrice);
}
