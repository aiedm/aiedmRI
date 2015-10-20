package com.ai.crm.common.businessinteraction.domain.model.impl;

import com.ai.common.rootentity.domain.model.impl.SpecificationInstanceEntity;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteraction;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BusinessInteractionItem extends SpecificationInstanceEntity implements IBusinessInteractionItem {
	@JsonIgnore
	private long businessInteractionItemId;
	
	private long businessInteractionItemSpecId;
	private int biiState;
	@JsonIgnore
	private IBusinessInteraction businessInteraction;
	
	public BusinessInteractionItem(){
		// TODO Auto-generated constructor stub
	}
	
	public BusinessInteractionItem(IBusinessInteraction bi) {
		this.setBusinessInteraction(bi);
	}	

	@Override
	public long getBusinessInteractionItemId() {
		return businessInteractionItemId;
	}

	@Override
	public void setBusinessInteraciotnItemId(long biiId) {
		this.businessInteractionItemId=biiId;
	}
	
	@Override
	public long getBusinessInteractionItemSpecId() {
		return businessInteractionItemSpecId;
	}

	@Override
	public void setBusinessInteractionItemSpecId(long biiSpecId) {	
		this.businessInteractionItemSpecId=biiSpecId;
	}
	

	protected int getBiiState() {
		return biiState;
	}

	protected void setBiiState(int biiState) {
		this.biiState=biiState;

	}

	@Override
	public IBusinessInteraction getBusinessInteraction() {
		return businessInteraction;
	}

	@Override
	public void setBusinessInteraction(IBusinessInteraction bi) {
		this.businessInteraction=bi;
	}

}
