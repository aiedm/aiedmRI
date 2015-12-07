package com.ai.crm.common.businessinteraction.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ai.common.rootentity.domain.model.EntityVersion;
import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="BI_BIZINTERACTION_ITEM")
public abstract class BusinessInteractionItem extends SpecInstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="BII_SPEC_ID")
	private long businessInteractionItemSpecId;
	
	@Column(name="BII_STATE")
	private int biiState;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="versionTime", column=@Column(name="ASIA_VERSION_TIME")),
        @AttributeOverride(name="versionOperatorId", column=@Column(name="ASIA_VERSION_OPERATOR_ID")),
        @AttributeOverride(name="version", column=@Column(name="ASIA_VERSION"))
    })
	private EntityVersion asIsAfterVersion;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="versionTime", column=@Column(name="TOBE_VERSION_TIME")),
        @AttributeOverride(name="versionOperatorId", column=@Column(name="TOBE_VERSION_OPERATOR_ID")),
        @AttributeOverride(name="version", column=@Column(name="TOBE_VERSION"))
    })
	private EntityVersion toBeVersion;
	
	private int action;	
	
	@ManyToOne
	@JoinColumn(name="BIZ_INTERACTION_ID")
	private BusinessInteraction businessInteraction;
	
	@OneToMany(mappedBy="businessInteractionItem",cascade=CascadeType.ALL,fetch=FetchType.LAZY)	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public EntityVersion getAsIsAfterVersion() {
		return asIsAfterVersion;
	}


	public void setAsIsAfterVersion(EntityVersion asIsAfterVersion) {
		this.asIsAfterVersion = asIsAfterVersion;
	}


	public EntityVersion getToBeVersion() {
		return toBeVersion;
	}


	public void setToBeVersion(EntityVersion toBeVersion) {
		this.toBeVersion = toBeVersion;
	}


	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
}
