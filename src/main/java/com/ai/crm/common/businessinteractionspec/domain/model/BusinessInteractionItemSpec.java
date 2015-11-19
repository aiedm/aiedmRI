package com.ai.crm.common.businessinteractionspec.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecificationEntity;
@Entity
@Table(name="BI_BIZINTERACTION_ITEM_SPEC")
public class BusinessInteractionItemSpec extends SpecificationEntity{
	private long biiSpecId;
	@ManyToOne
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
