package com.ai.crm.common.businessinteractionspec.domain.model.impl;

import com.ai.common.rootentity.domain.model.impl.SpecificationEntity;
import com.ai.crm.common.businessinteractionspec.domain.model.interfaces.IBusinessInteractionItemSpec;
import com.ai.crm.common.businessinteractionspec.domain.model.interfaces.IBusinessInteractionSpec;

public class BusinessInteractionItemSpec extends SpecificationEntity implements IBusinessInteractionItemSpec {
	private long biiSpecId;
	private IBusinessInteractionSpec biSpec;
	
	@Override
	public long getBusinessInteractionItemSpecId() {
		return this.biiSpecId;
	}

	@Override
	public void setBusinessInteraciotnItemSpecId(long biiSpecId) {
		this.biiSpecId=biiSpecId;
	}

	@Override
	public IBusinessInteractionSpec getBusinessInteractionSpec() {
		return this.biSpec;
	}

	@Override
	public void setBusinessInteractionSpec(IBusinessInteractionSpec biSpec) {
		this.biSpec=biSpec;
	}

}
