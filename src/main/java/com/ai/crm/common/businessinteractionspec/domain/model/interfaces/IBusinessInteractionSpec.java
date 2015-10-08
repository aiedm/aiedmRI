package com.ai.crm.common.businessinteractionspec.domain.model.interfaces;

import java.util.Set;

import com.ai.crm.common.rootentity.interfaces.ISpecificationEntity;

public interface IBusinessInteractionSpec extends ISpecificationEntity{
	long getBusinessInteractionSpecId();
	void setBusinessInteraciotnSpecId(long biSpecId);
	Set<IBusinessInteractionItemSpec> getBusinessInteractionItemSpecs();
	void addBusinessInteractionItemSpec(IBusinessInteractionItemSpec biiSpec);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);
	
}
