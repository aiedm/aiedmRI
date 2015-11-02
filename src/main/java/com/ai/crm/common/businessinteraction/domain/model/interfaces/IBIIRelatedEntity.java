package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IEntityVersion;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IBIIRelatedEntity extends IInstanceEntity {
	enum Action {
		CREATE(1),
		UPDATE(2),
		DELETE(3);
		private int value;  
	    private Action(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}
	IBusinessInteractionItem getBusinessInteractionItem();
	void setBusinessInteractionItem(IBusinessInteractionItem bii);
	IEntityVersion getAsIsAfterVersion();
	void setAsIsAfterVersion(IEntityVersion version);
	IInstanceEntity getToBeInstanceEntity();
	void setToBeInstanceEntity(IInstanceEntity entity);
	IEntityVersion getToBeVersion();
	void setToBeVersion(IEntityVersion version);
	int getAction();
	void setAction(int action);
}
