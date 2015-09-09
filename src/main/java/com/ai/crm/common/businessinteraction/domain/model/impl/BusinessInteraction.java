package com.ai.crm.common.businessinteraction.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteraction;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;

public abstract class BusinessInteraction implements IBusinessInteraction {
	private long businessInteractionId;
	private int biState;
	private Set<IBusinessInteractionItem> businessInteractionItems=new HashSet<IBusinessInteractionItem>();

	public BusinessInteraction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getBusinessInteractionId() {
		return this.businessInteractionId;
	}

	@Override
	public void setBusinessInteraciotnId(long biId) {
		this.businessInteractionId=biId;
	}

	protected int getBiState() {
		return this.biState;
	}

	protected void setBiState(int biState) {
		this.biState=biState;
	}

	@Override
	public Set<IBusinessInteractionItem> getBusinessInteractionItems() {
		return this.businessInteractionItems;
	}

	@Override
	public void addBusinessInteractionItem(IBusinessInteractionItem bii) {
		if (null!=bii){
			businessInteractionItems.add(bii);
			if(null==bii.getBusinessInteraction()){
				bii.setBusinessInteraction(this);
			}			
		}

	}

}