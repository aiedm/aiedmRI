package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyEnumValue;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;

public class PolicyEnumValue extends PolicyValue implements IPolicyEnumValue {
	private Set<ICharacteristicSpecValue> enumValues=new HashSet<ICharacteristicSpecValue>();
	private ICharacteristicSpecValue enumValue;
	public PolicyEnumValue() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<ICharacteristicSpecValue> getEnumValues() {
		return this.enumValues;
	}

	@Override
	public void addEnumValue(ICharacteristicSpecValue value) {
		if(null!=value){
			enumValues.add(value);
		}

	}

	@Override
	public ICharacteristicSpecValue getEnumValue() {
		return this.enumValue;
	}

	@Override
	public void setEnumValue(ICharacteristicSpecValue enumValue) {
		this.enumValue=enumValue;
	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}

	@Override
	public String toPolicyString() {
		StringBuffer sb=new StringBuffer();
		
		if (this.getEnumValues().size()>0){
			sb.append("(");
			for (ICharacteristicSpecValue specValue : this.getEnumValues()) {
				sb.append(specValue.getValue()).append(",");
			}
			sb.delete(sb.length()-1,sb.length()-1);
			sb.append(")");
		}else{
			sb.append(this.getEnumValue().getValue());
		}
		return sb.toString();
	}

}
