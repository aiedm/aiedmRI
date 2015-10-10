package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IBusinessInteraction  extends IInstanceEntity{
	long getBusinessInteractionId();
	void setBusinessInteraciotnId(long biId);
	Set<IBusinessInteractionItem> getBusinessInteractionItems();
	void addBusinessInteractionItem(IBusinessInteractionItem bii);
}
