package com.ai.common.policy.domain.service.interfaces;

import java.util.Map;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.common.rootentity.domain.model.impl.CheckResult;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public interface IPolicyExecute {
	Object execute(IPolicySet policySet,Map<String, Object> context) throws Exception;	
	CheckResult executeCheckPolicy(BaseEvent event,ISpecificationEntity specEntity,Map<String, Object> context)throws Exception;
}
