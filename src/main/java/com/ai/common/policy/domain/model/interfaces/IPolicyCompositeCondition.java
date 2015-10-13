package com.ai.common.policy.domain.model.interfaces;

import java.util.Set;

public interface IPolicyCompositeCondition extends IPolicyCondition {
	Set<IPolicyCompositeConditionOption> getChildren();
	void addChild(IPolicyCompositeConditionOption child);
}
