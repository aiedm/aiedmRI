package com.ai.common.rootentity.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicInstanceValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacteristic;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;

public abstract class SpecificationInstanceEntity extends RootEntity implements ISpecificationInstanceEntity {
	private  Set<IInstanceEntityCharacteristic> instanceEntityCharacteristics=new HashSet<IInstanceEntityCharacteristic>();
		
	public Set<IInstanceEntityCharacteristic> getCharacteristics() {
		return this.instanceEntityCharacteristics;
	}

	public void addCharacteristic(IInstanceEntityCharacteristic instanceEntityCharacteristic) {
		this.instanceEntityCharacteristics.add(instanceEntityCharacteristic);
		if (null==instanceEntityCharacteristic.getOwnerInstance()){
			instanceEntityCharacteristic.setOwnerInstance(this);
		}
	}
	
	public IInstanceEntityCharacteristic getInstEntityCharByCode(Set<IInstanceEntityCharacteristic> instCharacteristics,String characteristicCode)  throws Exception{
		IInstanceEntityCharacteristic instCharacteristic=null;
		for (IInstanceEntityCharacteristic aInstCharacteristic:instCharacteristics) {
			if(aInstCharacteristic.getCharacteristic().getCode().equalsIgnoreCase(characteristicCode)){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	
	public IInstanceEntityCharacteristic getInstEntityCharById(Set<IInstanceEntityCharacteristic> instCharacteristics,long characteristicId)  throws Exception{
		IInstanceEntityCharacteristic instCharacteristic=null;
		for (IInstanceEntityCharacteristic aInstCharacteristic:instCharacteristics) {
			if(aInstCharacteristic.getCharacteristic().getId()==characteristicId){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	

	public String getInstEntityCharValueByCharCode(Set<IInstanceEntityCharacteristic> instCharacteristics,String characteristicCode,int valuePosition)  throws Exception{
		IInstanceEntityCharacteristic instCharacteristic=getInstEntityCharByCode(instCharacteristics,characteristicCode);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}
	
	public String getInstEntityCharValueByCharId(Set<IInstanceEntityCharacteristic> instCharacteristics,long characteristicId,int valuePosition)  throws Exception{
		IInstanceEntityCharacteristic instCharacteristic=getInstEntityCharById(instCharacteristics,characteristicId);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}	
	
	public String getInstEntityCharValue(IInstanceEntityCharacteristic instCharacteristic,int valuePosition) throws Exception{
		String value=null;
		if (null!=instCharacteristic){
			Set<ICharacteristicInstanceValue> values=instCharacteristic.getCharacteristicInstanceValues();
			if(null!=values&&values.size()>0){
				if (valuePosition<0 || valuePosition>values.size()){
					throw new Exception("Invalid parameter valuePosition,must more then 0 and less then "+values.size());
				}
				ICharacteristicInstanceValue instValue= (ICharacteristicInstanceValue)values.toArray()[valuePosition];
				value=instValue.getInputedValue();
				if (null==value){
					value=instValue.getCharacteristicSpecValue().getValue();
				}				
			}
		}
		return value;
	}	


}
