package com.ai.crm.common.businessinteraction.domain.model.impl;

import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteraction;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;
import com.ai.crm.common.rootentity.impl.InstanceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BusinessInteractionItem extends InstanceEntity implements IBusinessInteractionItem {
	@JsonIgnore
	private long businessInteractionItemId;
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
	public boolean hasCharacteristic() {
		return true;
	}	

	@Override
	public long getBusinessInteractionItemId() {
		return businessInteractionItemId;
	}

	@Override
	public void setBusinessInteraciotnItemId(long biiId) {
		this.businessInteractionItemId=biiId;
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
