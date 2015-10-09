package com.ai.common.basetype.interfaces;

public interface IQuantityRange {
	IQuantity getMinQuantity();
	IQuantity getMaxQuantity();
	void setMinQuantity(IQuantity minQuantity);
	void setMaxQuantity(IQuantity maxQuantity);
}
