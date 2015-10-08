package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import com.ai.common.rootentity.interfaces.IInstanceEntity;

public interface IBusinessInteractionItem  extends IInstanceEntity {
	long getBusinessInteractionItemId();
	void setBusinessInteraciotnItemId(long biiId);
	IBusinessInteraction getBusinessInteraction();
	void setBusinessInteraction(IBusinessInteraction bi);
	long getBusinessInteractionItemSpecId();
	void setBusinessInteractionItemSpecId(long biiSpecId);
}
