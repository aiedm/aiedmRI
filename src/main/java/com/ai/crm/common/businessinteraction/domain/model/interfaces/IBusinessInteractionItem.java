package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;

public interface IBusinessInteractionItem  extends ISpecificationInstanceEntity {
	long getBusinessInteractionItemId();
	void setBusinessInteraciotnItemId(long biiId);
	IBusinessInteraction getBusinessInteraction();
	void setBusinessInteraction(IBusinessInteraction bi);
	long getBusinessInteractionItemSpecId();
	void setBusinessInteractionItemSpecId(long biiSpecId);
}
