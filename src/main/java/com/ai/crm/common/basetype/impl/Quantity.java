package com.ai.crm.common.basetype.impl;

import com.ai.crm.common.basetype.interfaces.IQuantity;

public class Quantity implements IQuantity {
	private long amount;
	private String unit;

	@Override
	public long getAmount() {
		return this.amount;
	}

	@Override
	public void setAmount(long amount) {
		this.amount=amount;
	}

	@Override
	public String getUnit() {
		return this.unit;
	}

	@Override
	public void setUnit(String unit) {
		this.unit=unit;
	}

}
