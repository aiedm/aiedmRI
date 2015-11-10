package com.ai.crm.common.businessinteractionspec.domain.model;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.rootentity.domain.model.SpecificationEntity;

public class BusinessInteractionSpec extends SpecificationEntity{
	private long biSpecId;
	private Set<BusinessInteractionItemSpec> businessInteractionItemSpecs=new HashSet<BusinessInteractionItemSpec>();
	private String name;
	private String code;
	
	public long getBusinessInteractionSpecId() {
		return this.biSpecId;
	}

	
	public void setBusinessInteraciotnSpecId(long biSpecId) {
		this.biSpecId=biSpecId;
	}

	
	public Set<BusinessInteractionItemSpec> getBusinessInteractionItemSpecs() {
		return this.businessInteractionItemSpecs;
	}

	
	public void addBusinessInteractionItemSpec(BusinessInteractionItemSpec biiSpec) {
		this.businessInteractionItemSpecs.add(biiSpec);
		if(null==biiSpec.getBusinessInteractionSpec()){
			biiSpec.setBusinessInteractionSpec(this);
		}

	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}

}
