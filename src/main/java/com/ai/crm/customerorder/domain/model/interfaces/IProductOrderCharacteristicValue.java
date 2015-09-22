package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;
import com.ai.crm.customerorder.domain.model.impl.ProductOrderCharacteristicValue;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = ProductOrderCharacteristicValue.class, name = "ProductOrderCharacteristicValue"),	    
	    })
public interface IProductOrderCharacteristicValue {
	IProductOrder getProductOrder();
	void setProductOrder(IProductOrder productOrder);
	ICharacteristicValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicValue value);
}
