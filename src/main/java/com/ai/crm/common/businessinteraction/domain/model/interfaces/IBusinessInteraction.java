package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import java.util.Set;

public interface IBusinessInteraction {
	long getBusinessInteractionId();
	void setBusinessInteraciotnId(long biId);
	Set<IBusinessInteractionItem> getBusinessInteractionItems();
	void addBusinessInteractionItem(IBusinessInteractionItem bii);
}
