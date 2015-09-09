package com.ai.crm.common.businessinteraction.domain.model.interfaces;

public interface IBusinessInteractionItem {
	long getBusinessInteractionItemId();
	void setBusinessInteraciotnItemId(long biiId);
	IBusinessInteraction getBusinessInteraction();
	void setBusinessInteraction(IBusinessInteraction bi);
}
