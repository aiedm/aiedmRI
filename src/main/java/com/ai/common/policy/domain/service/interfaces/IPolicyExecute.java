package com.ai.common.policy.domain.service.interfaces;

import java.util.Map;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;

public interface IPolicyExecute {
	Object execute(IPolicySet policySet,Map<String, Object> context) throws Exception;
}
