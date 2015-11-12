package com.ai.common.basetype;

import javax.persistence.Embeddable;

@Embeddable
public class Quantity{
	private long amount;
	private String unit;

	
	public long getAmount() {
		return this.amount;
	}

	
	public void setAmount(long amount) {
		this.amount=amount;
	}

	
	public String getUnit() {
		return this.unit;
	}

	
	public void setUnit(String unit) {
		this.unit=unit;
	}

}
