package com.ai.common.rootentity.domain.model;

import java.util.Set;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SpecInstanceEntity extends InstanceEntity {
			
	public abstract Set<SpecInstanceEntityCharacter> getCharacteristics();

	public abstract void addCharacteristic(SpecInstanceEntityCharacter instanceEntityCharacteristic);
	
	public SpecInstanceEntityCharacter getInstEntityCharByCode(String characteristicCode)  throws Exception{
		SpecInstanceEntityCharacter instCharacteristic=null;
		for (SpecInstanceEntityCharacter aInstCharacteristic:this.getCharacteristics()) {
			if(aInstCharacteristic.getCharacteristicSpec().getCode().equalsIgnoreCase(characteristicCode)){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	
	public SpecInstanceEntityCharacter getInstEntityCharById(long characteristicId)  throws Exception{
		SpecInstanceEntityCharacter instCharacteristic=null;
		for (SpecInstanceEntityCharacter aInstCharacteristic:this.getCharacteristics()) {
			if(aInstCharacteristic.getCharacteristicSpec().getId()==characteristicId){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	

	public String getInstEntityCharValueByCharCode(String characteristicCode,int valuePosition)  throws Exception{
		SpecInstanceEntityCharacter instCharacteristic=getInstEntityCharByCode(characteristicCode);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}
	
	public String getInstEntityCharValueByCharId(long characteristicId,int valuePosition)  throws Exception{
		SpecInstanceEntityCharacter instCharacteristic=getInstEntityCharById(characteristicId);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}	
	
	public String getInstEntityCharValue(SpecInstanceEntityCharacter instCharacteristic,int valuePosition) throws Exception{
		String value=null;
		if (null!=instCharacteristic){
			Set<SpecInstanceEntityCharacterValue> values=instCharacteristic.getCharacteristicInstanceValues();
			if(null!=values&&values.size()>0){
				if (valuePosition<0 || valuePosition>values.size()){
					throw new Exception("Invalid parameter valuePosition,must more then 0 and less then "+values.size());
				}
				SpecInstanceEntityCharacterValue instValue= (SpecInstanceEntityCharacterValue)values.toArray()[valuePosition];
				value=instValue.getInputedValue();
				if (null==value&&null!=instValue.getCharacteristicSpecValue()){
					value=instValue.getCharacteristicSpecValue().getValue();
				}				
			}
		}
		return value;
	}

}
