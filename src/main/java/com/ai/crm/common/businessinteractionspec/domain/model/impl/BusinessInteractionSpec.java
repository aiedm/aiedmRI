package com.ai.crm.common.businessinteractionspec.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.SpecificationEntity;
import com.ai.crm.common.businessinteractionspec.domain.model.interfaces.IBusinessInteractionItemSpec;
import com.ai.crm.common.businessinteractionspec.domain.model.interfaces.IBusinessInteractionSpec;

public class BusinessInteractionSpec extends SpecificationEntity implements IBusinessInteractionSpec {
	private long biSpecId;
	private Set<IBusinessInteractionItemSpec> businessInteractionItemSpecs=new HashSet<IBusinessInteractionItemSpec>();
	private String name;
	private String code;
	@Override
	public long getBusinessInteractionSpecId() {
		return this.biSpecId;
	}

	@Override
	public void setBusinessInteraciotnSpecId(long biSpecId) {
		this.biSpecId=biSpecId;
	}

	@Override
	public Set<IBusinessInteractionItemSpec> getBusinessInteractionItemSpecs() {
		return this.businessInteractionItemSpecs;
	}

	@Override
	public void addBusinessInteractionItemSpec(IBusinessInteractionItemSpec biiSpec) {
		this.businessInteractionItemSpecs.add(biiSpec);
		if(null==biiSpec.getBusinessInteractionSpec()){
			biiSpec.setBusinessInteractionSpec(this);
		}

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void setCode(String code) {
		this.code=code;
	}

}
