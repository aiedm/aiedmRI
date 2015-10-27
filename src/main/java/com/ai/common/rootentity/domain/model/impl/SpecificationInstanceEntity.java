package com.ai.common.rootentity.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;

public abstract class SpecificationInstanceEntity extends InstanceEntity implements ISpecificationInstanceEntity {
	private  Set<IInstanceEntityCharacter> instanceEntityCharacteristics=new HashSet<IInstanceEntityCharacter>();
		
	public Set<IInstanceEntityCharacter> getCharacteristics() {
		return this.instanceEntityCharacteristics;
	}

	public void addCharacteristic(IInstanceEntityCharacter instanceEntityCharacteristic) {
		this.instanceEntityCharacteristics.add(instanceEntityCharacteristic);
		if (null==instanceEntityCharacteristic.getOwnerInstance()){
			instanceEntityCharacteristic.setOwnerInstance(this);
		}
	}
	
	public IInstanceEntityCharacter getInstEntityCharByCode(String characteristicCode)  throws Exception{
		IInstanceEntityCharacter instCharacteristic=null;
		for (IInstanceEntityCharacter aInstCharacteristic:instanceEntityCharacteristics) {
			if(aInstCharacteristic.getCharacteristic().getCode().equalsIgnoreCase(characteristicCode)){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	
	public IInstanceEntityCharacter getInstEntityCharById(long characteristicId)  throws Exception{
		IInstanceEntityCharacter instCharacteristic=null;
		for (IInstanceEntityCharacter aInstCharacteristic:instanceEntityCharacteristics) {
			if(aInstCharacteristic.getCharacteristic().getId()==characteristicId){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	

	public String getInstEntityCharValueByCharCode(String characteristicCode,int valuePosition)  throws Exception{
		IInstanceEntityCharacter instCharacteristic=getInstEntityCharByCode(characteristicCode);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}
	
	public String getInstEntityCharValueByCharId(long characteristicId,int valuePosition)  throws Exception{
		IInstanceEntityCharacter instCharacteristic=getInstEntityCharById(characteristicId);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}	
	
	public String getInstEntityCharValue(IInstanceEntityCharacter instCharacteristic,int valuePosition) throws Exception{
		String value=null;
		if (null!=instCharacteristic){
			Set<IInstanceEntityCharacterValue> values=instCharacteristic.getCharacteristicInstanceValues();
			if(null!=values&&values.size()>0){
				if (valuePosition<0 || valuePosition>values.size()){
					throw new Exception("Invalid parameter valuePosition,must more then 0 and less then "+values.size());
				}
				IInstanceEntityCharacterValue instValue= (IInstanceEntityCharacterValue)values.toArray()[valuePosition];
				value=instValue.getInputedValue();
				if (null==value){
					value=instValue.getCharacteristicSpecValue().getValue();
				}				
			}
		}
		return value;
	}	


}
