package com.ai.crm.common.businessinteractionspec.domain.model.interfaces;

import java.util.Set;

import com.ai.crm.common.basetype.interfaces.ITimePeriod;
import com.ai.crm.common.rootentity.interfaces.IRootEntity;

public interface IBusinessInteractionSpec extends IRootEntity{
	long getBusinessInteractionSpecId();
	void setBusinessInteraciotnSpecId(long biSpecId);
	Set<IBusinessInteractionItemSpec> getBusinessInteractionItemSpecs();
	void addBusinessInteractionItem(IBusinessInteractionItemSpec biiSpec);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);
	ITimePeriod getValidPeriod();
	void setValidPeriod(ITimePeriod validPeriod);
}
