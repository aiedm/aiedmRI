package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;

public interface IBusinessInteraction  extends ISpecificationInstanceEntity{
	long getBusinessInteractionId();
	void setBusinessInteraciotnId(long biId);
	Set<IBusinessInteractionItem> getBusinessInteractionItems();
	void addBusinessInteractionItem(IBusinessInteractionItem bii);
}
