package com.ai.crm.common.businessinteractionspec.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecificationEntity;

@Entity
@Table(name="BI_BIZINTERACTION_SPEC")
public class BusinessInteractionSpec extends SpecificationEntity{
	private long biSpecId;
	@OneToMany(mappedBy="biSpec",fetch=FetchType.EAGER)
	private Set<BusinessInteractionItemSpec> businessInteractionItemSpecs=new HashSet<BusinessInteractionItemSpec>();
	
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

}
