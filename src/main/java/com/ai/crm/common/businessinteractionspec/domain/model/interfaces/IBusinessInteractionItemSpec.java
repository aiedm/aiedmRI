package com.ai.crm.common.businessinteractionspec.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public interface IBusinessInteractionItemSpec  extends ISpecificationEntity{
	long getBusinessInteractionItemSpecId();
	void setBusinessInteraciotnItemSpecId(long biiSpecId);
	IBusinessInteractionSpec getBusinessInteractionSpec();
	void setBusinessInteractionSpec(IBusinessInteractionSpec biSpec);	
}
