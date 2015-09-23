package com.ai.crm.common.basetype.impl;

import com.ai.crm.common.basetype.interfaces.IRate;

public class Rate implements IRate {
	private long numerator;
	private long denominator;

	@Override
	public long getNumerator() {
		return this.numerator;
	}

	@Override
	public void setNumerator(long numerator) {
		this.numerator=numerator;
	}

	@Override
	public long getDenominator() {
		return this.denominator;
	}

	@Override
	public void setDenominator(long denominator) {
		this.denominator=denominator;
	}

	@Override
	public long getPercent() {
		if (denominator==0){
			return -1;
		}else{
			return (numerator/denominator)*100;
		}
	}

}
