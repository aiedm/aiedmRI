package com.ai.common.basetype;

import javax.persistence.Embeddable;

@Embeddable
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
