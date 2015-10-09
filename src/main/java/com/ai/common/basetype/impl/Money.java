package com.ai.common.basetype.impl;

import com.ai.common.basetype.interfaces.IMoney;

public class Money implements IMoney {
	private long amount;
	private String currency;

	@Override
	public long getAmount() {
		// TODO Auto-generated method stub
		return this.amount;
	}

	@Override
	public void setAmount(long amount) {
		this.amount=amount;
	}

	@Override
	public String getCurrency() {
		// TODO Auto-generated method stub
		return this.currency;
	}

	@Override
	public void setCurrency(String currency) {
		this.currency=currency;
	}

}
