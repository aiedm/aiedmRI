package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.common.rootentity.domain.repository.interfaces.ICharacterSpecificationRepository;

@MappedSuperclass
public abstract class SpecInstanceEntity extends InstanceEntity {
	
	@Autowired
	@Transient
	private ICharacterSpecificationRepository characterSpecificationRepository ;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="specInstanceEntity")
	private  Set<SpecInstanceEntityCharacter> instanceEntityCharacteristics=new LinkedHashSet<SpecInstanceEntityCharacter>();
		
	public Set<SpecInstanceEntityCharacter> getCharacteristics() {
		return this.instanceEntityCharacteristics;
	}

	public void addCharacteristic(SpecInstanceEntityCharacter instanceEntityCharacteristic) {
		this.instanceEntityCharacteristics.add(instanceEntityCharacteristic);
		if (null==instanceEntityCharacteristic.getOwnerInstance()){
			instanceEntityCharacteristic.setOwnerInstance(this);
		}
	}
	
	public SpecInstanceEntityCharacter getInstEntityCharByCode(String characteristicCode)  throws Exception{
		SpecInstanceEntityCharacter instCharacteristic=null;
		for (SpecInstanceEntityCharacter aInstCharacteristic:instanceEntityCharacteristics) {
			long characteristicSpecId=aInstCharacteristic.getCharacteristicSpecId();
			CharacteristicSpec aCharacteristicSpec=characterSpecificationRepository.getCharacteristicSpecById(characteristicSpecId);
			if(aCharacteristicSpec.getCode().equalsIgnoreCase(characteristicCode)){
				instCharacteristic=aInstCharacteristic;
				break;
			}		
		}
		return instCharacteristic;				
	}
	
	public SpecInstanceEntityCharacter getInstEntityCharById(long characteristicId)  throws Exception{
		SpecInstanceEntityCharacter instCharacteristic=null;
		for (SpecInstanceEntityCharacter aInstCharacteristic:instanceEntityCharacteristics) {
			if(aInstCharacteristic.getCharacteristicSpecId()==characteristicId){
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
