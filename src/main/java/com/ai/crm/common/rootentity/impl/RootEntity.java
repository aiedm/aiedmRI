package com.ai.crm.common.rootentity.impl;

import com.ai.crm.common.rootentity.interfaces.IEntityVersion;
import com.ai.crm.common.rootentity.interfaces.IRootEntity;

public class RootEntity implements IRootEntity {
	private IEntityVersion version;

	@Override
	public IEntityVersion getVersion() {
		return this.version;
	}

	@Override
	public void setVersion(IEntityVersion version) {
		this.version=version;
	}

}
