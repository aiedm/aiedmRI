package com.ai.crm.common.businessinteraction.domain.model;

import com.ai.common.rootentity.domain.model.EntityVersion;
import com.ai.common.rootentity.domain.model.InstanceEntity;

public class BIIRelatedEntity extends InstanceEntity  {
	private BusinessInteractionItem bii;
	private EntityVersion asIsAfterVersion;
	private EntityVersion toBeVersion;
	private InstanceEntity toBeEntity;
	private int action;
	public BIIRelatedEntity() {
	}

	public BusinessInteractionItem getBusinessInteractionItem() {
		return this.bii;
	}

	public void setBusinessInteractionItem(BusinessInteractionItem bii) {
		this.bii=bii;
	}

	public EntityVersion getAsIsAfterVersion() {
		return this.asIsAfterVersion;
	}

	public void setAsIsAfterVersion(EntityVersion version) {
		this.asIsAfterVersion=version;
	}

	public InstanceEntity getToBeInstanceEntity() {
		return this.toBeEntity;
	}

	public void setToBeInstanceEntity(InstanceEntity entity) {
		this.toBeEntity=entity;
	}

	public EntityVersion getToBeVersion() {
		return this.toBeVersion;
	}

	public void setToBeVersion(EntityVersion version) {
		this.toBeVersion=version;
	}

	public int getAction() {
		return this.action;
	}

	public void setAction(int action) {
		this.action=action;
	}

}
