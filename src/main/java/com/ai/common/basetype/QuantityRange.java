package com.ai.common.basetype;

public class QuantityRange {
	private Quantity minQuantity;
	private Quantity maxQuantity;
	public QuantityRange() {
	}
	Quantity getMinQuantity(){
		return this.minQuantity;
	}
	
	Quantity getMaxQuantity(){
		return this.maxQuantity;
	}
	void setMinQuantity(Quantity minQuantity){
		this.minQuantity=minQuantity;
	}
	void setMaxQuantity(Quantity maxQuantity){
		this.maxQuantity=maxQuantity;
	}
}
