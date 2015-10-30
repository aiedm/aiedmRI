package com.ai.common.policy.domain.service.impl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.policy.domain.repository.interfaces.IPolicyRepository;
import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;
import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.common.rootentity.domain.model.impl.CheckResult;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public class GroovyPolicyExecute implements IPolicyExecute {
	@Autowired
	private IPolicyRepository policyRepository ;
	public GroovyPolicyExecute() {
	}

	@Override
	public Object execute(IPolicySet policySet,Map<String, Object> context) throws Exception{
		ClassLoader parent =ClassLoader.getSystemClassLoader();
		GroovyClassLoader loader =new GroovyClassLoader(parent);
		Class<?> clazz = loader.parseClass(policySet.toPolicyString());
		GroovyObject clazzObj =(GroovyObject)clazz.newInstance();
		return clazzObj.invokeMethod("executePolicy",context);
	}

	@Override
	public CheckResult executeCheckPolicy(BaseEvent event, ISpecificationEntity specEntity, Map<String, Object> context)
			throws Exception {
		CheckResult result=new CheckResult();
		Set<IPolicySet> policies=policyRepository.getEventRegistePolicies(event.getCode(), specEntity.getId());
		if (null!=policies && policies.size()>0){
			CheckResult perPolicyResult=new CheckResult();
			for (IPolicySet iPolicySet : policies) {
				context.put("CheckResult", perPolicyResult);
				execute(iPolicySet,context);
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
