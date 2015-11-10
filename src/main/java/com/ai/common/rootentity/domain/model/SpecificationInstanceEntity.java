package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.repository.interfaces.ICharacterSpecificationRepository;

@Component
public abstract class SpecificationInstanceEntity extends InstanceEntity {
	
	@Autowired
	private ICharacterSpecificationRepository characterSpecificationRepository ;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="instanceEntity")
	private  Set<InstanceEntityCharacter> instanceEntityCharacteristics=new LinkedHashSet<InstanceEntityCharacter>();
		
	public Set<InstanceEntityCharacter> getCharacteristics() {
		return this.instanceEntityCharacteristics;
	}

	public void addCharacteristic(InstanceEntityCharacter instanceEntityCharacteristic) {
		this.instanceEntityCharacteristics.add(instanceEntityCharacteristic);
		if (null==instanceEntityCharacteristic.getOwnerInstance()){
			instanceEntityCharacteristic.setOwnerInstance(this);
		}
	}
	
	public InstanceEntityCharacter getInstEntityCharByCode(String characteristicCode)  throws Exception{
		InstanceEntityCharacter instCharacteristic=null;
		for (InstanceEntityCharacter aInstCharacteristic:instanceEntityCharacteristics) {
			long characteristicSpecId=aInstCharacteristic.getCharacteristicSpecId();
			CharacteristicSpec aCharacteristicSpec=characterSpecificationRepository.getCharacteristicSpecById(characteristicSpecId);
			if(aCharacteristicSpec.getCode().equalsIgnoreCase(characteristicCode)){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	
	public InstanceEntityCharacter getInstEntityCharById(long characteristicId)  throws Exception{
		InstanceEntityCharacter instCharacteristic=null;
		for (InstanceEntityCharacter aInstCharacteristic:instanceEntityCharacteristics) {
			if(aInstCharacteristic.getCharacteristicSpecId()==characteristicId){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	

	public String getInstEntityCharValueByCharCode(String characteristicCode,int valuePosition)  throws Exception{
		InstanceEntityCharacter instCharacteristic=getInstEntityCharByCode(characteristicCode);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}
	
	public String getInstEntityCharValueByCharId(long characteristicId,int valuePosition)  throws Exception{
		InstanceEntityCharacter instCharacteristic=getInstEntityCharById(characteristicId);
		return getInstEntityCharValue(instCharacteristic,valuePosition);
	}	
	
	public String getInstEntityCharValue(InstanceEntityCharacter instCharacteristic,int valuePosition) throws Exception{
		String value=null;
		if (null!=instCharacteristic){
			Set<InstanceEntityCharacterValue> values=instCharacteristic.getCharacteristicInstanceValues();
			if(null!=values&&values.size()>0){
				if (valuePosition<0 || valuePosition>values.size()){
					throw new Exception("Invalid parameter valuePosition,must more then 0 and less then "+values.size());
				}
				InstanceEntityCharacterValue instValue= (InstanceEntityCharacterValue)values.toArray()[valuePosition];
				value=instValue.getInputedValue();
				if (null==value){
					long characteristicSpecValueId=instValue.getCharacteristicSpecValueId();
					CharacteristicSpecValue characteristicSpecValue =characterSpecificationRepository.getCharacteristicSpecValueById(characteristicSpecValueId);
					value=characteristicSpecValue.getValue();
				}				
			}
		}
		return value;
	}	


}
