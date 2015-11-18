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
import com.ai.common.rootentity.domain.model.EventSubscriber;
import com.ai.common.rootentity.domain.model.SpecificationEntity;
import com.ai.common.rootentity.domain.model.SubscribedEventPolicy;
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
		long specificationEntityId=0;
		if (null!=specEntity){
			specificationEntityId=specEntity.getId();
		}
		Set<EventSubscriber> subscribedEvents=policyRepository.getEventRegistePolicies(event.getCode(), specificationEntityId);
		if (null!=subscribedEvents && subscribedEvents.size()>0){
			CheckResult perPolicyResult=new CheckResult();
			for (EventSubscriber eventSubscriber : subscribedEvents) {
				Set<SubscribedEventPolicy> policies= eventSubscriber.getPolicies();
				if(null!=policies&&policies.size()>0){
					for (SubscribedEventPolicy subscribedEventPolicy : policies) {
						context.put("CheckResult", perPolicyResult);
						execute(subscribedEventPolicy.getPolicySet(),context);
						if(null!=perPolicyResult.getErrorInfomations()&&perPolicyResult.getErrorInfomations().size()>0){
							result.getErrorInfomations().addAll(perPolicyResult.getErrorInfomations());
						}
						if(null!=perPolicyResult.getInformInfomations()&&perPolicyResult.getInformInfomations().size()>0){
							result.getInformInfomations().addAll(perPolicyResult.getInformInfomations());
						}
					}
				}

			}
		}
		return result;
	}

}
