package com.ai.common.basetype;

import javax.persistence.Embeddable;

@Embeddable
public class Money{
	private long amount;
	private String currency;

	
	public long getAmount() {
		return this.amount;
	}

	
	public void setAmount(long amount) {
		this.amount=amount;
	}

	
	public String getCurrency() {
		return this.currency;
	}

	
	public void setCurrency(String currency) {
		this.currency=currency;
	}

}
