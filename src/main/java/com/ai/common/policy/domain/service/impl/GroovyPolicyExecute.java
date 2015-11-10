package com.ai.common.policy.domain.service.impl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.policy.domain.model.PolicySet;
import com.ai.common.policy.domain.repository.interfaces.IPolicyRepository;
import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;
import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.common.rootentity.domain.model.CheckResult;
import com.ai.common.rootentity.domain.model.SpecificationEntity;
@Component
public class GroovyPolicyExecute implements IPolicyExecute {
	@Autowired
	private IPolicyRepository policyRepository ;
	public GroovyPolicyExecute() {
	}

	@Override
	public Object execute(PolicySet policySet,Map<String, Object> context) throws Exception{
		ClassLoader parent =ClassLoader.getSystemClassLoader();
		GroovyClassLoader loader =new GroovyClassLoader(parent);
		Class<?> clazz = loader.parseClass(policySet.toPolicyString());
		GroovyObject clazzObj =(GroovyObject)clazz.newInstance();
		return clazzObj.invokeMethod("executePolicy",context);
	}

	@Override
	public CheckResult executeCheckPolicy(BaseEvent event, SpecificationEntity specEntity, Map<String, Object> context)
			throws Exception {
		CheckResult result=new CheckResult();
		long specEntityId=0;
		if(null!=specEntity){
			specEntityId=specEntity.getId();
		}
		Set<PolicySet> policies=policyRepository.getEventRegistePolicies(event.getCode(), specEntityId);
		if (null!=policies && policies.size()>0){
			CheckResult perPolicyResult=new CheckResult();
			for (PolicySet PolicySet : policies) {
				context.put("CheckResult", perPolicyResult);
				execute(PolicySet,context);
				if(null!=perPolicyResult.getErrorInfomations()&&perPolicyResult.getErrorInfomations().size()>0){
					result.getErrorInfomations().addAll(perPolicyResult.getErrorInfomations());
				}
				if(null!=perPolicyResult.getInformInfomations()&&perPolicyResult.getInformInfomations().size()>0){
					result.getInformInfomations().addAll(perPolicyResult.getInformInfomations());
				}
			}
		}
		return result;
	}

}
