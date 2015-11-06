package com.ai.crm.common.businessinteraction.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;
import com.ai.crm.common.businessinteractionspec.domain.model.interfaces.IBusinessInteractionSpec;

public interface IBusinessInteraction  extends ISpecificationInstanceEntity{
	long getBusinessInteractionId();
	void setBusinessInteractionId(long biId);
	long getBusinessInteractionSpecId();
	void setBusinessInteractionSpecId(long biiSpecId);
	Set<IBusinessInteractionItem> getBusinessInteractionItems();
	void addBusinessInteractionItem(IBusinessInteractionItem bii);
}
