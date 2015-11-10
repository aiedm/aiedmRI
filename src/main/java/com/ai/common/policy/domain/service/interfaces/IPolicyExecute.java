package com.ai.common.policy.domain.service.interfaces;

import java.util.Map;

import com.ai.common.policy.domain.model.PolicySet;
import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.common.rootentity.domain.model.CheckResult;
import com.ai.common.rootentity.domain.model.SpecificationEntity;

public interface IPolicyExecute {
	Object execute(PolicySet policySet,Map<String, Object> context) throws Exception;	
	CheckResult executeCheckPolicy(BaseEvent event,SpecificationEntity specEntity,Map<String, Object> context)throws Exception;
}
