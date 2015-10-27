package com.ai.common.rootentity.domain.service.impl;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;

public class CharacteristicUtil{
	
	public static IInstanceEntityCharacter getInstEntityCharByCode(Set<IInstanceEntityCharacter> instCharacteristics,String characteristicCode)  throws Exception{
		IInstanceEntityCharacter instCharacteristic=null;
		for (IInstanceEntityCharacter aInstCharacteristic:instCharacteristics) {
			if(aInstCharacteristic.getCharacteristic().getCode().equalsIgnoreCase(characteristicCode)){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	
	public static IInstanceEntityCharacter getInstEntityCharById(Set<IInstanceEntityCharacter> instCharacteristics,long characteristicId)  throws Exception{
		IInstanceEntityCharacter instCharacteristic=null;
		for (IInstanceEntityCharacter aInstCharacteristic:instCharacteristics) {
			if(aInstCharacteristic.getCharacteristic().getId()==characteristicId){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	

	public static String getInstEntityCharValueByCharCode(Set<IInstanceEntityCharacter> instCharacteristics,String characteristicCode,int valuePosition)  throws Exception{
		IInstanceEntityCharacter instCharacteristic=getInstEntityCharByCode(instCharacteristics,characteristicCode);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}
	
	public static String getInstEntityCharValueByCharId(Set<IInstanceEntityCharacter> instCharacteristics,long characteristicId,int valuePosition)  throws Exception{
		IInstanceEntityCharacter instCharacteristic=getInstEntityCharById(instCharacteristics,characteristicId);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}	
	
	public static String getInstEntityCharValue(IInstanceEntityCharacter instCharacteristic,int valuePosition) throws Exception{
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
