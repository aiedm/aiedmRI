package com.ai.common.basetype;

import javax.persistence.Embeddable;

@Embeddable
public class Rate {
	private long numerator;
	private long denominator;

	
	public long getNumerator() {
		return this.numerator;
	}

	
	public void setNumerator(long numerator) {
		this.numerator=numerator;
	}

	
	public long getDenominator() {
		return this.denominator;
	}

	
	public void setDenominator(long denominator) {
		this.denominator=denominator;
	}

	
	public long getPercent() {
		if (denominator==0){
			return -1;
		}else{
			return (numerator/denominator)*100;
		}
	}

}
