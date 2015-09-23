package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import java.util.Set;

import com.ai.crm.common.rootentity.interfaces.IRootEntity;

public interface IBusinessInteraction  extends IRootEntity{
	long getBusinessInteractionId();
	void setBusinessInteraciotnId(long biId);
	Set<IBusinessInteractionItem> getBusinessInteractionItems();
	void addBusinessInteractionItem(IBusinessInteractionItem bii);
}
