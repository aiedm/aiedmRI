package com.ai.crm.common.businessinteraction.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.SpecificationInstanceEntity;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteraction;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BusinessInteraction extends SpecificationInstanceEntity implements IBusinessInteraction {
	@JsonIgnore
	private long businessInteractionId;
	private int biState;
	@JsonIgnore
	private Set<IBusinessInteractionItem> businessInteractionItems=new HashSet<IBusinessInteractionItem>();
	private long biiSpecId;
	
	public BusinessInteraction() {
		
	}	

	@Override
	public long getBusinessInteractionId() {
		return this.businessInteractionId;
	}

	@Override
	public void setBusinessInteractionId(long biId) {
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
	
	@Override
	public long getBusinessInteractionSpecId(){
		return this.biiSpecId;
	}

	@Override
	public void setBusinessInteractionSpecId(long biiSpecId){
		this.biiSpecId=biiSpecId;
	}
}
