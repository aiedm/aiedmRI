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
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="BI_SPEC_ID",discriminatorType=DiscriminatorType.INTEGER)
@Table(name="BI_BIZINTERACTION")
public abstract class BusinessInteraction extends SpecInstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	@Column(name="BI_STATE")
	private int biState;
	@OneToMany(mappedBy="businessInteraction",fetch=FetchType.LAZY)
	private Set<BusinessInteractionItem> businessInteractionItems=new HashSet<BusinessInteractionItem>();
	@Column(name="BI_SPEC_ID")
	private long biSpecId;
	@Column(name="BI_CODE")
	private String code;
	@OneToMany(mappedBy="businessInteraction",fetch=FetchType.LAZY)
	private Set<BICharacter> bICharacteristic=new LinkedHashSet<BICharacter>();
	
	protected BusinessInteraction(){
		
	}
	
	public  Set<BICharacter> getBICharacteristics(){
		return bICharacteristic;
	}
	
	public void addBICharacteristic(BICharacter character){
		if(null!=character){
			this.bICharacteristic.add(character);
			super.addCharacteristic((SpecInstanceEntityCharacter)character);
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

	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

}
