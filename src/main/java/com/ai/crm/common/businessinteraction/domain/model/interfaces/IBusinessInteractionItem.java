package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import com.ai.crm.common.rootentity.interfaces.IInstanceEntity;

public interface IBusinessInteractionItem  extends IInstanceEntity {
	long getBusinessInteractionItemId();
	void setBusinessInteraciotnItemId(long biiId);
	IBusinessInteraction getBusinessInteraction();
	void setBusinessInteraction(IBusinessInteraction bi);
}
