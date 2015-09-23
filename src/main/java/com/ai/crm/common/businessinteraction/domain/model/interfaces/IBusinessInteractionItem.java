package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import com.ai.crm.common.rootentity.interfaces.IRootEntity;

public interface IBusinessInteractionItem  extends IRootEntity {
	long getBusinessInteractionItemId();
	void setBusinessInteraciotnItemId(long biiId);
	IBusinessInteraction getBusinessInteraction();
	void setBusinessInteraction(IBusinessInteraction bi);
}
