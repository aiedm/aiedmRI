package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
@Entity
public abstract class BusinessInteractionItem extends SpecInstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long businessInteractionItemSpecId;
	private int biiState;
	private BIIRelatedEntity relatedEntity;
	private BusinessInteraction businessInteraction;
	
	public BusinessInteractionItem(){
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
