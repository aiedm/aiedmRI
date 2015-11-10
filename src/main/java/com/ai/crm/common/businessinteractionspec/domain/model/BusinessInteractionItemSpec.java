package com.ai.crm.common.businessinteractionspec.domain.model;

import com.ai.common.rootentity.domain.model.SpecificationEntity;

public class BusinessInteractionItemSpec extends SpecificationEntity{
	private long biiSpecId;
	private BusinessInteractionSpec biSpec;
	
	
	public long getBusinessInteractionItemSpecId() {
		return this.biiSpecId;
	}

	
	public void setBusinessInteraciotnItemSpecId(long biiSpecId) {
		this.biiSpecId=biiSpecId;
	}

	
	public BusinessInteractionSpec getBusinessInteractionSpec() {
		return this.biSpec;
	}

	
	public void setBusinessInteractionSpec(BusinessInteractionSpec biSpec) {
		this.biSpec=biSpec;
	}

}
