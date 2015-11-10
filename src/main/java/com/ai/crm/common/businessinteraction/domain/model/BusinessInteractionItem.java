package com.ai.crm.common.businessinteraction.domain.model;

import com.ai.common.rootentity.domain.model.SpecificationInstanceEntity;

public abstract class BusinessInteractionItem extends SpecificationInstanceEntity {
	private long businessInteractionItemId;
	
	private long businessInteractionItemSpecId;
	private int biiState;
	private BIIRelatedEntity relatedEntity;
	private BusinessInteraction businessInteraction;
	
	public BusinessInteractionItem(){
		// TODO Auto-generated constructor stub
	}
	
	public BusinessInteractionItem(BusinessInteraction bi) {
		this.setBusinessInteraction(bi);
	}	

	
	public long getBusinessInteractionItemId() {
		return businessInteractionItemId;
	}

	
	public void setBusinessInteraciotnItemId(long biiId) {
		this.businessInteractionItemId=biiId;
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
}
