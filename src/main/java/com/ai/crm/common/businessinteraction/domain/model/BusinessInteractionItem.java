package com.ai.crm.common.businessinteraction.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="BI_BIZINTERACTION_ITEM")
public abstract class BusinessInteractionItem extends SpecInstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	@Column(name="BII_SPEC_ID")
	private long businessInteractionItemSpecId;
	@Column(name="BII_STATE")
	private int biiState;
	@OneToOne
	private BIIRelatedEntity relatedEntity;
	@ManyToOne
	private BusinessInteraction businessInteraction;
	@OneToMany(mappedBy="businessInteractionItem",fetch=FetchType.LAZY)	
	private Set<BIICharacter> biiCharacters=new LinkedHashSet<BIICharacter>();
	
	
	public  Set<BIICharacter> getBiiCharacteristics(){
		return biiCharacters;
	}
	
	
	public void addBiiCharacteristic(BIICharacter character){
		if(null!=character){
			this.biiCharacters.add(character);
			super.addCharacteristic((SpecInstanceEntityCharacter)character);
		}
	}
	
	
	protected BusinessInteractionItem(){
	}
	
	public BusinessInteractionItem(BusinessInteraction bi) {
		this.setBusinessInteraction(bi);
	}	

	
	public long getBusinessInteractionItemSpecId() {
		return businessInteractionItemSpecId;
	}

	
	public void setBusinessInteractionItemSpecId(long biiSpecId) {	
		this.businessInteractionItemSpecId=biiSpecId;
	}
	

	protected int getBiiState() {
		return biiState;
	}

	protected void setBiiState(int biiState) {
		this.biiState=biiState;

	}

	
	public BusinessInteraction getBusinessInteraction() {
		return businessInteraction;
	}

	
	public void setBusinessInteraction(BusinessInteraction bi) {
		this.businessInteraction=bi;
	}
	
	public BIIRelatedEntity getRelatedEntity(){
		return this.relatedEntity;
	}
	
	public void setRelatedEntity(BIIRelatedEntity relatedEntity){
		this.relatedEntity=relatedEntity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
