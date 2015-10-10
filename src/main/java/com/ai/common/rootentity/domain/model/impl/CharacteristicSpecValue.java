package com.ai.common.rootentity.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class CharacteristicSpecValue extends RootEntity implements ICharacteristicSpecValue {
	@JsonIgnore
	private ICharacteristicSpec characteristic;
	private long id;
	private String value;
	private String displayValue;
	private boolean isDefault;
	private long valueFrom;
	   
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public long getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(long valueFrom) {
		this.valueFrom = valueFrom;
	}

	public long getValueTo() {
		return valueTo;
	}

	public void setValueTo(long valueTo) {
		this.valueTo = valueTo;
	}

	public long getRangeInterval() {
		return rangeInterval;
	}

	public void setRangeInterval(long rangeInterval) {
		this.rangeInterval = rangeInterval;
	}

	private long valueTo;
	   private long rangeInterval;	
	@Override
	public ICharacteristicSpec getCharacteristic() {
		return this.characteristic;
	}

	@Override
	public void setCharacteristic(ICharacteristicSpec characteristic) {
		this.characteristic=characteristic;
	}

}
