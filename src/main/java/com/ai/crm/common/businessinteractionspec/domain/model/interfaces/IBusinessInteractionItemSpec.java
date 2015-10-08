package com.ai.crm.common.businessinteractionspec.domain.model.interfaces;

import com.ai.crm.common.rootentity.interfaces.ISpecificationEntity;

public interface IBusinessInteractionItemSpec  extends ISpecificationEntity{
	long getBusinessInteractionItemSpecId();
	void setBusinessInteraciotnItemSpecId(long biiSpecId);
	IBusinessInteractionSpec getBusinessInteractionSpec();
	void setBusinessInteractionSpec(IBusinessInteractionSpec biSpec);	
}
