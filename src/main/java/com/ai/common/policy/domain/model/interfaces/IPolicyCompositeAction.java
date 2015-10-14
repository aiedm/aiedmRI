package com.ai.common.policy.domain.model.interfaces;

import java.util.Set;

public interface IPolicyCompositeAction extends IPolicyAction {
	Set<IPolicyAction> getChildren();
	void addChild(IPolicyAction child);
}
