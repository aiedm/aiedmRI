package com.ai.crm.common.businessinteractionspec.domain.model.interfaces;

import com.ai.crm.common.basetype.interfaces.ITimePeriod;
import com.ai.crm.common.rootentity.interfaces.IRootEntity;

public interface IBusinessInteractionItemSpec  extends IRootEntity{
	long getBusinessInteractionItemSpecId();
	void setBusinessInteraciotnItemSpecId(long biiSpecId);
	IBusinessInteractionSpec getBusinessInteractionSpec();
	void setBusinessInteraction(IBusinessInteractionSpec biSpec);
	ITimePeriod getValidPeriod();
	void setValidPeriod(ITimePeriod validPeriod);	
}
