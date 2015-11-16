package com.ai.crm.common.businessinteraction.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="biSpecId",discriminatorType=DiscriminatorType.INTEGER)
public abstract class BusinessInteraction extends SpecInstanceEntity {
	private long id;
	@Column
	private int biState;
	@OneToMany(mappedBy="businessInteraction",fetch=FetchType.LAZY)
	private Set<BusinessInteractionItem> businessInteractionItems=new HashSet<BusinessInteractionItem>();
	@Column
	private long biSpecId;
	@Column
	private String code;
	@OneToMany(mappedBy="specInstanceEntity",fetch=FetchType.LAZY)
	private Set<SpecInstanceEntityCharacter> characterInstances=new LinkedHashSet<SpecInstanceEntityCharacter>();
	
	@Override
	public  Set<SpecInstanceEntityCharacter> getCharacteristics(){
		return this.characterInstances;
	}
	
	@Override
	public void addCharacteristic(SpecInstanceEntityCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			character.setOwnerInstance(this);
		}
	}
	
	public BusinessInteraction(long biSpecId) {
		this.biSpecId=biSpecId;
	}	

	protected int getBiState() {
		return this.biState;
	}

	protected void setBiState(int biState) {
		this.biState=biState;
	}

	public Set<BusinessInteractionItem> getBusinessInteractionItems() {
		return this.businessInteractionItems;
	}

	public void addBusinessInteractionItem(BusinessInteractionItem bii) {
		if (null!=bii){
			businessInteractionItems.add(bii);
			if(null==bii.getBusinessInteraction()){
				bii.setBusinessInteraction(this);
			}			
		}

	}
	
	public long getBusinessInteractionSpecId(){
		return this.biSpecId;
	}

	protected String getCode() {
		return code;
	}

	protected void setCode(String code) {
		this.code = code;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

}
