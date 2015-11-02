package com.ai.crm.common.businessinteraction.domain.model.impl;

import com.ai.common.rootentity.domain.model.impl.InstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.IEntityVersion;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBIIRelatedEntity;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBusinessInteractionItem;

public class BIIRelatedEntity extends InstanceEntity implements IBIIRelatedEntity {
	private IBusinessInteractionItem bii;
	private IEntityVersion asIsAfterVersion;
	private IEntityVersion toBeVersion;
	private IInstanceEntity toBeEntity;
	private int action;
	public BIIRelatedEntity() {
	}

	@Override
	public IBusinessInteractionItem getBusinessInteractionItem() {
		return this.bii;
	}

	@Override
	public void setBusinessInteractionItem(IBusinessInteractionItem bii) {
		this.bii=bii;
	}

	@Override
	public IEntityVersion getAsIsAfterVersion() {
		return this.asIsAfterVersion;
	}

	@Override
	public void setAsIsAfterVersion(IEntityVersion version) {
		this.asIsAfterVersion=version;
	}

	@Override
	public IInstanceEntity getToBeInstanceEntity() {
		return this.toBeEntity;
	}

	@Override
	public void setToBeInstanceEntity(IInstanceEntity entity) {
		this.toBeEntity=entity;
	}

	@Override
	public IEntityVersion getToBeVersion() {
		return this.toBeVersion;
	}

	@Override
	public void setToBeVersion(IEntityVersion version) {
		this.toBeVersion=version;
	}

	@Override
	public int getAction() {
		return this.action;
	}

	@Override
	public void setAction(int action) {
		this.action=action;
	}

}
